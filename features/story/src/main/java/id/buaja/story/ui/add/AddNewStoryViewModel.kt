package id.buaja.story.ui.add

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.buaja.common.LocationLiveData
import id.buaja.common.result.Result
import id.buaja.common.result.isLoading
import id.buaja.story.domain.usecase.add.AddNewStoryUseCase
import id.buaja.story.ui.add.model.AddNewStoryEventState
import id.buaja.story.ui.add.model.AddNewStoryScreenUiState
import id.buaja.story.ui.add.model.AddNewStoryUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Julsapargi Nursam on 5/28/22.
 * Mobile Engineer - Android
 */

@HiltViewModel
class AddNewStoryViewModel @Inject constructor(
    application: Application,
    private val addNewStoryUseCase: AddNewStoryUseCase,
): AndroidViewModel(application) {
    private val _uiState = MutableStateFlow(AddNewStoryScreenUiState())
    val uiState = _uiState.asStateFlow()

    private val _locationState = LocationLiveData(application)
    val locationState get() = _locationState

    fun onEvent(event: AddNewStoryEventState) {
        when(event) {
            is AddNewStoryEventState.DescriptionsChanged -> {
                _uiState.update {
                    it.copy(
                        description = event.description
                    )
                }
            }

            is AddNewStoryEventState.PhotoChanged -> {
                _uiState.update {
                    it.copy(
                        photo = event.uri
                    )
                }
            }

            is AddNewStoryEventState.Upload -> {
                addNewStory(
                    lat = event.lat,
                    lon = event.lon
                )
            }
        }
    }

    fun isEnableUpload(): Boolean {
        return _uiState.value.description.isNotEmpty() && _uiState.value.photo != Uri.EMPTY
    }

    private fun addNewStory(
        lat: Float,
        lon: Float
    ) {
        viewModelScope.launch {
            addNewStoryUseCase.invoke(
                description = _uiState.value.description,
                lat = lat,
                lon = lon,
                photo = _uiState.value.photo
            ).collect { result ->
                val addNewStoryState = when (result) {
                    is Result.Loading -> {
                        AddNewStoryUiState.Loading
                    }

                    is Result.Success -> {
                        val data = result.data

                        AddNewStoryUiState.Success(data)
                    }

                    is Result.Error -> {
                        AddNewStoryUiState.Error(result.exception)
                    }
                }

                _uiState.update { state ->
                    state.copy(
                        addNewStoryState = addNewStoryState,
                        loading = result.isLoading()
                    )
                }
            }
        }
    }

    fun startLocationUpdate() {
        _locationState.startLocationUpdate()
    }

    fun clearState() {
        _uiState.value = AddNewStoryScreenUiState()
    }
}