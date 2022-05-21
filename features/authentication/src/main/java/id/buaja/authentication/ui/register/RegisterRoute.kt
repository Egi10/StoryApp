package id.buaja.authentication.ui.register

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import id.buaja.authentication.ui.register.model.RegisterEventState

/**
 * Created by Julsapargi Nursam on 5/20/22.
 * Mobile Engineer - Android
 */

@Composable
fun RegisterRoute(
    viewModel: RegisterViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.collectAsState()

    RegisterScreen(
        registerUiState = uiState.value.registerState,
        email = uiState.value.email,
        isErrorEmail = uiState.value.emailError,
        onEmailChange = {
            viewModel.onEvent(RegisterEventState.EmailChanged(it))
        },
        onEmailValidation = {
            viewModel.onEvent(RegisterEventState.EmailValidation(it))
        },
        name = uiState.value.name,
        onNameChange = {
            viewModel.onEvent(RegisterEventState.NameChanged(it))
        },
        password = uiState.value.password,
        isErrorPassword = uiState.value.passwordError,
        onPasswordChange = {
            viewModel.onEvent(RegisterEventState.PasswordChanged(it))
        },
        onPasswordValidation = {
            viewModel.onEvent(RegisterEventState.PasswordValidation(it))
        },
        enableSubmit = viewModel.isEnableSubmit(),
        submit = {
            viewModel.onEvent(RegisterEventState.Submit)
        }
    )
}