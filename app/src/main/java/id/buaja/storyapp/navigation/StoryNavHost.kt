package id.buaja.storyapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import id.buaja.authentication.ui.login.navigation.LoginNavigation
import id.buaja.authentication.ui.login.navigation.loginGraph
import id.buaja.authentication.ui.register.navigation.RegisterNavigation
import id.buaja.authentication.ui.register.navigation.registerGraph
import id.buaja.home.navigation.HomeNavigation
import id.buaja.home.navigation.homeGraph
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
        modifier = modifier
    ) {
        splashGraph(
            navigationToHome = {
                navController.navigate(
                    route = if (viewModel.isLogin) {
                        HomeNavigation.home.route
                    } else {
                        LoginNavigation.route
                    }
                ) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        inclusive = true
                    }
                }
            }
        )

        homeGraph(
            navController = navController
        )

        loginGraph(
            navigationToSignUp = {
                navController.navigate(
                    route = RegisterNavigation.route,
                )
            },
            navigationToHome = {
                navController.navigate(
                    route = HomeNavigation.home.route
                )
            }
        )

        registerGraph(
            navigationToLogin = {
                navController.navigate(
                    route = LoginNavigation.route
                ) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        inclusive = true
                    }
                }
            }
        )
    }
}