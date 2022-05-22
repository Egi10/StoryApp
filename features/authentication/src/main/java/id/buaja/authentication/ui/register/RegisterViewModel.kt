package id.buaja.authentication.ui.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.buaja.authentication.domain.model.register.RegisterParam
import id.buaja.authentication.domain.usecase.register.RegisterUseCase
import id.buaja.authentication.ui.register.model.RegisterEventState
import id.buaja.authentication.ui.register.model.RegisterScreenUiState
import id.buaja.authentication.ui.register.model.RegisterUiState
import id.buaja.common.result.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
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

    fun onEvent(event: RegisterEventState) {
        when (event) {
            is RegisterEventState.EmailChanged -> {
                _uiState.update {
                    it.copy(
                        email = event.email
                    )
                }
            }

            is RegisterEventState.EmailValidation -> {
                _uiState.update {
                    it.copy(
                        emailError = event.validation
                    )
                }
            }

            is RegisterEventState.NameChanged -> {
                _uiState.update {
                    it.copy(
                        name = event.name
                    )
                }
            }

            is RegisterEventState.PasswordChanged -> {
                _uiState.update {
                    it.copy(
                        password = event.password
                    )
                }
            }

            is RegisterEventState.PasswordValidation -> {
                _uiState.update {
                    it.copy(
                        passwordError = event.validation
                    )
                }
            }

            is RegisterEventState.Submit -> {
                register()
            }
        }
    }

    fun isEnableSubmit(): Boolean {
        return !_uiState.value.passwordError && !_uiState.value.emailError
                && _uiState.value.email.isNotEmpty() && _uiState.value.name.isNotEmpty()
                && _uiState.value.password.isNotEmpty()
    }

    private fun register() {
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
                        RegisterUiState.Error(it.exception)
                    }
                }

                _uiState.update { uiState ->
                    uiState.copy(
                        registerState = registerUiState
                    )
                }
            }
        }
    }

    fun clearState() {
        _uiState.value = RegisterScreenUiState()
    }
}