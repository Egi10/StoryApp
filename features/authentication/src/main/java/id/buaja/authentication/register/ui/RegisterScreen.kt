package id.buaja.authentication.register.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import id.buaja.authentication.register.ui.model.RegisterUiState

/**
 * Created by Julsapargi Nursam on 5/20/22.
 * Mobile Engineer - Android
 */

@Composable
fun RegisterScreen(
    registerUiState: RegisterUiState?
) {
    when(registerUiState) {
        is RegisterUiState.Loading -> {

        }

        is RegisterUiState.Success -> {

        }

        is RegisterUiState.Error -> {

        }
        else -> { /** Null */ }
    }

    Column {

    }
}