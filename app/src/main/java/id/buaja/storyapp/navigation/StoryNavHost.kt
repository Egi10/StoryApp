package id.buaja.storyapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import id.buaja.authentication.navigation.authenticationGraph
import id.buaja.home.navigation.homeGraph
import id.buaja.navigation.AuthenticationNavigation
import id.buaja.navigation.HomeNavigation
import id.buaja.splash.navigation.splashGraph
import id.buaja.storyapp.ui.StoryAppViewModel

/**
 * Created by Julsapargi Nursam on 5/21/22.
 * Mobile Engineer - Android
 */

@Composable
fun StoryNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String,
    viewModel: StoryAppViewModel = hiltViewModel()
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
        route = "ROOT_NAV_HOST"
    ) {
        splashGraph(
            navigationToHome = {
                navController.navigate(
                    route = if (viewModel.isLogin) {
                        HomeNavigation.home.route
                    } else {
                        AuthenticationNavigation.login.route
                    }
                ) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        inclusive = true
                    }
                }
            }
        )

        authenticationGraph(
            navController = navController
        )

        homeGraph(
            navController = navController
        )
    }
}