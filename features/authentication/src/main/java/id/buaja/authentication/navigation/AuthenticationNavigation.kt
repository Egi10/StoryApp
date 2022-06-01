package id.buaja.authentication.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import id.buaja.authentication.ui.login.LoginRoute
import id.buaja.authentication.ui.register.RegisterRoute
import id.buaja.navigation.AuthenticationNavigation
import id.buaja.navigation.HomeNavigation

/**
 * Created by Julsapargi Nursam on 6/1/22.
 * Mobile Engineer - Android
 */

fun NavGraphBuilder.authenticationGraph(
    navController: NavController
) {
    navigation(
        startDestination = AuthenticationNavigation.login.route,
        route = AuthenticationNavigation.route
    ) {
        composable(
            route = AuthenticationNavigation.login.route,
        ) {
            LoginRoute(
                navigationToSignUp = {
                    navController.navigate(
                        route = AuthenticationNavigation.register.route
                    )
                },
                navigationToHome = {
                    navController.navigate(
                        route = HomeNavigation.home.route
                    ) {
                        popUpTo(
                            route = AuthenticationNavigation.login.route
                        ) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(
            route = AuthenticationNavigation.register.route
        ) {
            RegisterRoute(
                navigationToLogin = {
                    navController.navigate(
                        route = AuthenticationNavigation.login.route
                    ) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}