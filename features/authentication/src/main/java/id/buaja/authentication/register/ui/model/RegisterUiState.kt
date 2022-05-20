package id.buaja.authentication.register.ui.model

import id.buaja.authentication.register.domain.model.Register

/**
 * Created by Julsapargi Nursam on 5/20/22.
 * Mobile Engineer - Android
 */

data class RegisterScreenUiState(
    val email: String = "",
    val name: String = "",
    val password: String = "",

    val registerState: RegisterUiState? = null
)

sealed interface RegisterUiState {
    data class Success(val register: Register) : RegisterUiState
    object Error : RegisterUiState
    object Loading : RegisterUiState
}

