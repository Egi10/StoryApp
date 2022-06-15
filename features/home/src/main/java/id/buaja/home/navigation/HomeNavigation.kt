package id.buaja.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import id.buaja.story.navigation.storyGraph
import id.buaja.story.domain.model.Story
import id.buaja.story.ui.details.DetailStoryRoute
import id.buaja.story.ui.list.ListStoryRoute
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
        startDestination = StoryNavigation.list.route,
        route = HomeNavigation.route
    ) {
        composable(
            route = StoryNavigation.list.route
        ) {
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