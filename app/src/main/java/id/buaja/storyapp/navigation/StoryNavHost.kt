package id.buaja.storyapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import id.buaja.authentication.ui.login.navigation.LoginNavigation
import id.buaja.authentication.ui.login.navigation.loginGraph
import id.buaja.authentication.ui.register.navigation.RegisterNavigation
import id.buaja.authentication.ui.register.navigation.registerGraph

/**
 * Created by Julsapargi Nursam on 5/21/22.
 * Mobile Engineer - Android
 */

@Composable
fun StoryNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = LoginNavigation.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        loginGraph(
            navigationToSignUp = {
                navController.navigate(
                    route = RegisterNavigation.route
                )
            }
        )

        registerGraph()
    }
}