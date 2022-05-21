package id.buaja.authentication.ui.login.model

/**
 * Created by Julsapargi Nursam on 5/21/22.
 * Mobile Engineer - Android
 */

sealed class LoginEventState {
    data class EmailChanged(val email: String) : LoginEventState()
    data class EmailValidation(val validation: Boolean) : LoginEventState()

    data class PasswordChanged(val password: String) : LoginEventState()
    data class PasswordValidation(val validation: Boolean) : LoginEventState()

    object Submit : LoginEventState()
}
