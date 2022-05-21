package id.buaja.authentication.ui.login.model

import id.buaja.authentication.domain.model.login.Login
import id.buaja.authentication.domain.model.register.Register

/**
 * Created by Julsapargi Nursam on 5/21/22.
 * Mobile Engineer - Android
 */

data class LoginScreenUiState(
    val email: String = "",
    val emailError: Boolean = false,
    val password: String = "",
    val passwordError: Boolean = false,

    val loginState: LoginUiState? = null
)

sealed interface LoginUiState {
    data class Success(val register: Login) : LoginUiState
    data class Error(val exception: String? = null) : LoginUiState
    object Loading : LoginUiState
}