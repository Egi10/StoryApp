package id.buaja.maps.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.buaja.common.LocationLiveData
import id.buaja.common.result.Result
import id.buaja.maps.domain.usecase.GetAllStoryLocationUseCase
import id.buaja.maps.ui.model.MapsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Julsapargi Nursam on 22/06/22
 * Mobile Engineer - Android
 */

@HiltViewModel
class MapsViewModel @Inject constructor(
    application: Application,
    private val getAllStoryLocationUseCase: GetAllStoryLocationUseCase
): AndroidViewModel(application) {
    private val _uiState = MutableStateFlow(MapsUiState())
    val uiState = _uiState.asStateFlow()

    private val _locationState = LocationLiveData(application)
    val locationState get() = _locationState

    init {
        getAllStoryMaps()
    }

    private fun getAllStoryMaps() {
        viewModelScope.launch {
            getAllStoryLocationUseCase.invoke()
                .collect {
                    when(it) {
                        is Result.Loading -> {
                            _uiState.update { state ->
                                state.copy(
                                    loading = true
                                )
                            }
                        }

                        is Result.Success -> {
                            _uiState.update { state ->
                                state.copy(
                                    loading = false,
                                    data = it.data
                                )
                            }
                        }

                        is Result.Error -> {
                            _uiState.update { state ->
                                state.copy(
                                    loading = false,
                                    error = it.exception ?: ""
                                )
                            }
                        }
                    }
                }
        }
    }

    fun startLocationUpdate() {
        _locationState.startLocationUpdate()

        _uiState.update {
            it.copy(
                locationNow = true
            )
        }
    }
}