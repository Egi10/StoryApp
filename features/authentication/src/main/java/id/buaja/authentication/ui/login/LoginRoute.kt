package id.buaja.authentication.login.ui

import androidx.compose.runtime.Composable

/**
 * Created by Julsapargi Nursam on 5/21/22.
 * Mobile Engineer - Android
 */

@Composable
fun LoginRoute(
    navigationToSignUp: (Int) -> Unit
) {
    LoginScreen(
        navigationToSignUp = navigationToSignUp
    )
}