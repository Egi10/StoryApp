package id.buaja.authentication.ui.register.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import id.buaja.authentication.ui.register.RegisterRoute
import id.buaja.navigation.utils.StoryNavigationDestination

/**
 * Created by Julsapargi Nursam on 5/21/22.
 * Mobile Engineer - Android
 */

object RegisterNavigation : StoryNavigationDestination {
    override val route: String
        get() = "register_route"
    override val destination: String
        get() = "register_destination"
}

fun NavGraphBuilder.registerGraph(
    navigationToLogin: () -> Unit
) {
    composable(
        route = RegisterNavigation.route
    ) {
        RegisterRoute(
            navigationToLogin = navigationToLogin
        )
    }
}