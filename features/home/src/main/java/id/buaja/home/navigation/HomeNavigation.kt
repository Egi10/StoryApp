package id.buaja.home.navigation

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import id.buaja.home.R
import id.buaja.home.ui.HomeRoute
import id.buaja.navigation.AuthenticationNavigation
import id.buaja.navigation.HomeNavigation
import id.buaja.navigation.StoryNavigation
import id.buaja.story.domain.model.Story
import id.buaja.story.navigation.storyGraph
import id.buaja.story.ui.details.DetailStoryRoute
import id.buaja.story.ui.list.ListStoryRoute

/**
 * Created by Julsapargi Nursam on 5/21/22.
 * Mobile Engineer - Android
 */

data class HomeDestination(
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int
)

val HOME_DESTINATION = listOf(
    HomeDestination(
        route = StoryNavigation.list.route,
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        iconTextId = R.string.home
    ),
    HomeDestination(
        route = "Maps",
        selectedIcon = Icons.Filled.Lock,
        unselectedIcon = Icons.Outlined.Lock,
        iconTextId = R.string.home
    ),
)

fun NavGraphBuilder.homeGraph(
    navController: NavController
) {
    navigation(
        startDestination = StoryNavigation.list.route,
        route = HomeNavigation.route
    ) {
        composable(
            route = HomeNavigation.home.route
        ) {
            var selectedItem by remember { mutableStateOf(StoryNavigation.list.route) }

            HomeRoute(
                onSelectedNavigation = {
                    selectedItem = it
                },
                selectedItem = selectedItem,
                content = { padding ->
                    Crossfade(
                        modifier = Modifier
                            .padding(padding),
                        targetState = selectedItem
                    ) {
                        when (it) {
                            StoryNavigation.list.route -> {
                                Story(
                                    navController = navController
                                )
                            }

                            "Maps" -> {
                                Text(text = "Tes")
                            }
                        }
                    }
                }
            )
        }

        composable(
            route = StoryNavigation.detail.route,
        ) {
            val story =
                navController.previousBackStackEntry?.arguments?.getParcelable<Story>("story")

            if (story != null) {
                DetailStoryRoute(
                    story = story,
                    onBackPressed = {
                        navController.popBackStack()
                    }
                )
            }
        }

        storyGraph(
            navigationToHome = {
                navController.popBackStack()
            },
            onBackPressed = {
                navController.popBackStack()
            }
        )
    }
}

@Composable
private fun Story(navController: NavController) {
    ListStoryRoute(
        navigationToLogin = {
            navController.navigate(
                route = AuthenticationNavigation.login.route
            ) {
                popUpTo(
                    route = StoryNavigation.list.route
                ) {
                    inclusive = true
                }
            }
        },
        navigationToDetail = {
            navController.currentBackStackEntry?.arguments?.apply {
                putParcelable(
                    "story", it
                )
            }
            navController.navigate(
                route = StoryNavigation.detail.route,
            ) {
                popUpTo(
                    route = StoryNavigation.list.route
                )
            }
        },
        navigationToAddNewStory = {
            navController.navigate(
                route = StoryNavigation.addNewStory.route
            ) {
                popUpTo(
                    route = StoryNavigation.list.route
                )
            }
        }
    )
}