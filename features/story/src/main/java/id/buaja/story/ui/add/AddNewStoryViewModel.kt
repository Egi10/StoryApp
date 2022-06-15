package id.buaja.story.ui.add

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.buaja.story.domain.usecase.add.AddNewStoryUseCase
import id.buaja.story.ui.add.model.AddNewStoryEventState
import id.buaja.story.ui.add.model.AddNewStoryScreenUiState
import id.buaja.story.ui.add.model.AddNewStoryUiState
import id.buaja.common.result.Result
import id.buaja.common.result.isLoading
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
    private val addNewStoryUseCase: AddNewStoryUseCase,
): ViewModel() {
    private val _uiState = MutableStateFlow(AddNewStoryScreenUiState())
    val uiState = _uiState.asStateFlow()

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
                addNewStory()
            }
        }
    }

    fun isEnableUpload(): Boolean {
        return _uiState.value.description.isNotEmpty() && _uiState.value.photo != Uri.EMPTY
    }

    private fun addNewStory() {
        viewModelScope.launch {
            addNewStoryUseCase.invoke(
                description = _uiState.value.description,
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

    fun clearState() {
        _uiState.value = AddNewStoryScreenUiState()
    }
}