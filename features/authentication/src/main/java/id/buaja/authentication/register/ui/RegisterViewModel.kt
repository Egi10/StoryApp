package id.buaja.authentication.register.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.buaja.authentication.register.domain.model.RegisterParam
import id.buaja.authentication.register.domain.usecase.RegisterUseCase
import id.buaja.authentication.register.ui.model.RegisterScreenUiState
import id.buaja.authentication.register.ui.model.RegisterUiState
import id.buaja.common.result.Result
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Julsapargi Nursam on 5/20/22.
 * Mobile Engineer - Android
 */

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(RegisterScreenUiState())
    val uiState = _uiState.asStateFlow()

    fun register() {
        viewModelScope.launch {
            registerUseCase.invoke(
                registerParam = RegisterParam(
                    email = _uiState.value.email,
                    name = _uiState.value.name,
                    password = _uiState.value.password
                )
            ).collect {
                val registerUiState = when (it) {
                    is Result.Loading -> {
                        RegisterUiState.Loading
                    }

                    is Result.Success -> {
                        RegisterUiState.Success(
                            it.data
                        )
                    }

                    is Result.Error -> {
                        RegisterUiState.Error
                    }
                }

                _uiState.update { registerScreenUiState ->
                    registerScreenUiState.copy(
                        registerState = registerUiState
                    )
                }
            }
        }
    }

    fun setEmail(email: String) {
        _uiState.update {
            it.copy(
                email = email
            )
        }
    }

    fun setName(name: String) {
        _uiState.update {
            it.copy(
                name = name
            )
        }
    }

    fun setPassword(password: String) {
        _uiState.update {
            it.copy(
                password = password
            )
        }
    }
}