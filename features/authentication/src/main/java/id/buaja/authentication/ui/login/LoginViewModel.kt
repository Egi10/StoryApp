package id.buaja.authentication.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.buaja.authentication.data.source.RemoteDataSource
import id.buaja.authentication.domain.model.login.LoginParam
import id.buaja.authentication.domain.usecase.login.LoginUseCase
import id.buaja.authentication.ui.login.model.LoginEventState
import id.buaja.authentication.ui.login.model.LoginScreenUiState
import id.buaja.authentication.ui.login.model.LoginUiState
import id.buaja.common.result.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Julsapargi Nursam on 5/21/22.
 * Mobile Engineer - Android
 */

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(LoginScreenUiState())
    val uiState = _uiState.asStateFlow()

    fun onEvent(event: LoginEventState) {
        when (event) {
            is LoginEventState.EmailChanged -> {
                _uiState.update {
                    it.copy(
                        email = event.email
                    )
                }
            }

            is LoginEventState.EmailValidation -> {
                _uiState.update {
                    it.copy(
                        emailError = event.validation
                    )
                }
            }

            is LoginEventState.PasswordChanged -> {
                _uiState.update {
                    it.copy(
                        password = event.password
                    )
                }
            }

            is LoginEventState.PasswordValidation -> {
                _uiState.update {
                    it.copy(
                        passwordError = event.validation
                    )
                }
            }

            is LoginEventState.Submit -> {
                login()
            }
        }
    }

    fun isEnableSubmit(): Boolean {
        return !_uiState.value.passwordError && !_uiState.value.emailError
                && _uiState.value.email.isNotEmpty() && _uiState.value.password.isNotEmpty()
    }

    private fun login() {
        viewModelScope.launch {
            loginUseCase.invoke(
                param = LoginParam(
                    email = _uiState.value.email,
                    password = _uiState.value.password
                )
            ).collect {
                val loginUiState = when (it) {
                    is Result.Loading -> {
                        LoginUiState.Loading
                    }

                    is Result.Success -> {
                        LoginUiState.Success(
                            it.data
                        )
                    }

                    is Result.Error -> {
                        LoginUiState.Error(it.exception)
                    }
                }

                _uiState.update { state ->
                    state.copy(
                        loginState = loginUiState
                    )
                }
            }
        }
    }
}