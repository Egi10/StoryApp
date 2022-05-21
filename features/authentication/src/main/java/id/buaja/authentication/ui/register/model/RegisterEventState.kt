package id.buaja.authentication.ui.register.model

/**
 * Created by Julsapargi Nursam on 5/21/22.
 * Mobile Engineer - Android
 */

sealed class RegisterEventState {
    data class EmailChanged(val email: String) : RegisterEventState()
    data class EmailValidation(val validation: Boolean) : RegisterEventState()

    data class NameChanged(val name: String) : RegisterEventState()

    data class PasswordChanged(val password: String) : RegisterEventState()
    data class PasswordValidation(val validation: Boolean) : RegisterEventState()

    object Submit : RegisterEventState()
}
