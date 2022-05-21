package id.buaja.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import id.buaja.home.ui.HomeRoute
import id.buaja.navigation.StoryNavigationDestination

/**
 * Created by Julsapargi Nursam on 5/21/22.
 * Mobile Engineer - Android
 */

object HomeNavigation : StoryNavigationDestination {
    override val route: String
        get() = "route_home"
    override val destination: String
        get() = "destination_home"
}

fun NavGraphBuilder.homeGraph() {
    composable(
        route = HomeNavigation.route
    ) {
        HomeRoute()
    }
}