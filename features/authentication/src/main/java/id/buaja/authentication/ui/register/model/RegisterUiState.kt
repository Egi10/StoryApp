package id.buaja.authentication.ui.register.model

import id.buaja.authentication.domain.model.register.Register

/**
 * Created by Julsapargi Nursam on 5/20/22.
 * Mobile Engineer - Android
 */

data class RegisterScreenUiState(
    val email: String = "",
    val emailError: Boolean = false,
    val name: String = "",
    val password: String = "",
    val passwordError: Boolean = false,

    val registerState: RegisterUiState? = null
)

sealed interface RegisterUiState {
    data class Success(val register: Register) : RegisterUiState
    data class Error(val exception: Throwable? = null) : RegisterUiState
    object Loading : RegisterUiState
}