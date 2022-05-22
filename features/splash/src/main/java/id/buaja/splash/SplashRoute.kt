package id.buaja.splash

import androidx.compose.runtime.Composable

/**
 * Created by Julsapargi Nursam on 5/22/22.
 * Mobile Engineer - Android
 */

@Composable
fun SplashRoute(
    navigationToHome: () -> Unit
) {
    SplashScreen(
        navigationToHome = navigationToHome
    )
}