package id.buaja.splash.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import id.buaja.navigation.SplashNavigation
import id.buaja.splash.SplashRoute

/**
 * Created by Julsapargi Nursam on 5/22/22.
 * Mobile Engineer - Android
 */

fun NavGraphBuilder.splashGraph(
    navigationToHome: () -> Unit
) {
    composable(
        route = SplashNavigation.route
    ) {
        SplashRoute(
            navigationToHome = navigationToHome
        )
    }
}