package id.buaja.authentication.ui.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import id.buaja.authentication.ui.login.model.LoginEventState

/**
 * Created by Julsapargi Nursam on 5/21/22.
 * Mobile Engineer - Android
 */

@Composable
fun LoginRoute(
    navigationToSignUp: (Int) -> Unit,
    navigationToHome: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.collectAsState()

    LoginScreen(
        uiState = uiState.value.loginState,
        enableLogin = viewModel.isEnableSubmit(),
        navigationToSignUp = navigationToSignUp,
        email = uiState.value.email,
        isErrorEmail = uiState.value.emailError,
        onEmailChange = {
            viewModel.onEvent(LoginEventState.EmailChanged(it))
        },
        onEmailValidation = {
            viewModel.onEvent(LoginEventState.EmailValidation(it))
        },
        password = uiState.value.password,
        isErrorPassword = uiState.value.passwordError,
        onPasswordChange = {
            viewModel.onEvent(LoginEventState.PasswordChanged(it))
        },
        onPasswordValidation = {
            viewModel.onEvent(LoginEventState.PasswordValidation(it))
        },
        submit = {
            viewModel.onEvent(LoginEventState.Submit)
        },
        onSuccess = navigationToHome
    )
}