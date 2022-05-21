package id.buaja.storyapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import id.buaja.authentication.ui.login.navigation.LoginNavigation
import id.buaja.home.navigation.HomeNavigation
import id.buaja.storyapp.navigation.StoryNavHost
import id.buaja.ui.thema.StoryAppTheme

/**
 * Created by Julsapargi Nursam on 5/21/22.
 * Mobile Engineer - Android
 */

@Composable
fun StoryApp(
    viewModel: StoryAppViewModel = hiltViewModel()
) {
    StoryAppTheme {
        val navController = rememberNavController()

        val token = viewModel.tokenFlow.collectAsState(initial = "")

        val startDestination = if (token.value.isNotEmpty()) {
            HomeNavigation.route
        } else {
            LoginNavigation.route
        }

        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            StoryNavHost(
                navController = navController,
                startDestination = startDestination
            )
        }
    }
}