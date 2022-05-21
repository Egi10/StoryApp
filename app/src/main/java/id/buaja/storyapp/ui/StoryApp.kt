package id.buaja.storyapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import id.buaja.storyapp.navigation.StoryNavHost
import id.buaja.ui.thema.StoryAppTheme

/**
 * Created by Julsapargi Nursam on 5/21/22.
 * Mobile Engineer - Android
 */

@Composable
fun StoryApp() {
    StoryAppTheme {
        val navController = rememberNavController()

        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            StoryNavHost(
                navController = navController
            )
        }
    }
}