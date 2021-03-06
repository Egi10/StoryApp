package id.buaja.home.navigation

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import id.buaja.home.R
import id.buaja.home.ui.HomeRoute
import id.buaja.maps.ui.MapsRoute
import id.buaja.navigation.AuthenticationNavigation
import id.buaja.navigation.HomeNavigation
import id.buaja.navigation.MapsNavigation
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
        route = MapsNavigation.route,
        selectedIcon = Icons.Filled.LocationOn,
        unselectedIcon = Icons.Outlined.LocationOn,
        iconTextId = R.string.maps
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

                            MapsNavigation.route -> {
                                Maps(
                                    navController = navController
                                )
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
                    navController.currentBackStackEntry?.destination?.route ?: return@navigate
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

@Composable
private fun Maps(navController: NavController) {
    MapsRoute(
        onNavigationToAddStory = {
            navController.navigate(
                route = StoryNavigation.addNewStory.route
            ) {
                popUpTo(
                    route = MapsNavigation.route
                )
            }
        }
    )
}