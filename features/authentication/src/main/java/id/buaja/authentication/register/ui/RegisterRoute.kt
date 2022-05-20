package id.buaja.authentication.register.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel

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
        registerUiState = uiState.value.registerState
    )
}