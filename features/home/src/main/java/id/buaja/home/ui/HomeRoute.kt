package id.buaja.home.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

/**
 * Created by Julsapargi Nursam on 5/21/22.
 * Mobile Engineer - Android
 */

@Composable
fun HomeRoute(
    viewModel: HomeViewModel = hiltViewModel(),
    navigationToLogin: () -> Unit
) {
    HomeScreen(
        navigationToLogin = {
            viewModel.clearToken()
            navigationToLogin.invoke()
        }
    )
}