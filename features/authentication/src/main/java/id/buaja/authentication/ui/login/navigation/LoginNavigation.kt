package id.buaja.authentication.ui.login.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import id.buaja.authentication.login.ui.LoginRoute
import id.buaja.navigation.StoryNavigationDestination

/**
 * Created by Julsapargi Nursam on 5/21/22.
 * Mobile Engineer - Android
 */

object LoginNavigation : StoryNavigationDestination {
    override val route: String
        get() = "login_route"
    override val destination: String
        get() = "login_destination"
}

fun NavGraphBuilder.loginGraph(
    navigationToSignUp: (Int) -> Unit
) {
    composable(
        route = LoginNavigation.route,
    ) {
        LoginRoute(
            navigationToSignUp = navigationToSignUp
        )
    }
}