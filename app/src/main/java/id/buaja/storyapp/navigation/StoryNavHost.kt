package id.buaja.storyapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import id.buaja.authentication.register.ui.navigation.RegisterNavigation
import id.buaja.authentication.register.ui.navigation.registerGraph

/**
 * Created by Julsapargi Nursam on 5/21/22.
 * Mobile Engineer - Android
 */

@Composable
fun StoryNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = RegisterNavigation.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        registerGraph()
    }
}