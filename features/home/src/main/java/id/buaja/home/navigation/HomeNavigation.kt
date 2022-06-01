package id.buaja.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import id.buaja.add_new_story.navigation.storyGraph
import id.buaja.home.domain.model.Story
import id.buaja.home.ui.detail.DetailStoryRoute
import id.buaja.home.ui.home.HomeRoute
import id.buaja.navigation.AuthenticationNavigation
import id.buaja.navigation.HomeNavigation
import id.buaja.navigation.StoryNavigation

/**
 * Created by Julsapargi Nursam on 5/21/22.
 * Mobile Engineer - Android
 */

fun NavGraphBuilder.homeGraph(
    navController: NavController
) {
    navigation(
        startDestination = HomeNavigation.home.route,
        route = HomeNavigation.route
    ) {
        composable(
            route = HomeNavigation.home.route
        ) {
            HomeRoute(
                navigationToLogin = {
                    navController.navigate(
                        route = AuthenticationNavigation.login.route
                    ) {
                        popUpTo(
                            route = HomeNavigation.home.route
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
                        route = HomeNavigation.detail.route,
                    ) {
                        popUpTo(
                            route = HomeNavigation.home.route
                        )
                    }
                },
                navigationToAddNewStory = {
                    navController.navigate(
                        route = StoryNavigation.addNewStory.route
                    ) {
                        popUpTo(
                            route = HomeNavigation.home.route
                        )
                    }
                }
            )
        }

        composable(
            route = HomeNavigation.detail.route,
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