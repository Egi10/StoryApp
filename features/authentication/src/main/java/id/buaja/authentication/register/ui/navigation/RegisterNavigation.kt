package id.buaja.authentication.register.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import id.buaja.authentication.register.ui.RegisterRoute
import id.buaja.navigation.StoryNavigationDestination

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

fun NavGraphBuilder.registerGraph() {
    composable(
        route = RegisterNavigation.route
    ) {
        RegisterRoute()
    }
}