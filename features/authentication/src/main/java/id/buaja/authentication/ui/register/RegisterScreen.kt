package id.buaja.authentication.ui.register

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.buaja.authentication.R
import id.buaja.authentication.ui.components.TextBar
import id.buaja.authentication.ui.register.model.RegisterUiState
import id.buaja.ui.components.InputType
import id.buaja.ui.components.StoryButton
import id.buaja.ui.components.StoryOutlinedTextField
import id.buaja.ui.extensions.Space
import id.buaja.ui.extensions.toast

/**
 * Created by Julsapargi Nursam on 5/20/22.
 * Mobile Engineer - Android
 */

@Composable
fun RegisterScreen(
    registerUiState: RegisterUiState?,
    email: String,
    isErrorEmail: Boolean,
    onEmailChange: (String) -> Unit,
    onEmailValidation: (Boolean) -> Unit,
    name: String,
    onNameChange: (String) -> Unit,
    password: String,
    isErrorPassword: Boolean,
    onPasswordChange: (String) -> Unit,
    onPasswordValidation: (Boolean) -> Unit,
    submit: () -> Unit,
    enableSubmit: Boolean,
    navigationToLogin: () -> Unit
) {
    val context = LocalContext.current
    var loading by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(registerUiState) {
        when (registerUiState) {
            is RegisterUiState.Loading -> {
                loading = true
            }

            is RegisterUiState.Success -> {
                loading = false

                context.toast(registerUiState.register.message)

                navigationToLogin.invoke()
            }

            is RegisterUiState.Error -> {
                loading = false

                registerUiState.exception?.let { context.toast(it) }
            }

            else -> {
                /** Null */
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Space(height = 24.dp)

        TextBar(
            title = stringResource(R.string.welcome),
            description = stringResource(R.string.message_welcome)
        )

        Space(height = 24.dp)

        StoryOutlinedTextField(
            value = email,
            onValueChange = onEmailChange,
            label = stringResource(R.string.email),
            placeholder = stringResource(R.string.placeholder_email),
            inputType = InputType.email,
            onValidation = onEmailValidation,
            isError = isErrorEmail,
            errorMessage = stringResource(R.string.message_email_error)
        )

        Space(height = 10.dp)

        StoryOutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = stringResource(R.string.name),
            placeholder = stringResource(R.string.placeholder_name)
        )

        Space(height = 10.dp)

        StoryOutlinedTextField(
            value = password,
            onValueChange = onPasswordChange,
            label = stringResource(R.string.password),
            placeholder = stringResource(R.string.placeholder_password),
            inputType = InputType.password,
            onValidation = onPasswordValidation,
            isError = isErrorPassword,
            errorMessage = stringResource(R.string.message_error_password)
        )

        Box(
            modifier = Modifier
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            StoryButton(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = submit,
                text = stringResource(R.string.sign_up),
                enabled = enableSubmit,
                loading = loading
            )
        }
    }
}

@Preview(
    device = Devices.PIXEL_2,
    showBackground = true,
)
@Composable
private fun RegisterScreenPreview() {
    RegisterScreen(
        registerUiState = null,
        name = "Julsapargi Nursam",
        onNameChange = { },
        isErrorEmail = false,
        email = "julsaparginursam@gmail.com",
        onEmailChange = { },
        onEmailValidation = { },
        password = "123456",
        isErrorPassword = false,
        onPasswordChange = { },
        onPasswordValidation = { },
        submit = { },
        enableSubmit = false,
        navigationToLogin = { }
    )
}