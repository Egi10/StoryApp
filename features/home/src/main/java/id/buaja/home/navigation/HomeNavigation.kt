package id.buaja.home.navigation

import androidx.navigation.*
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.composable
import id.buaja.home.ui.detail.DetailStoryRoute
import id.buaja.home.ui.home.HomeRoute
import id.buaja.navigation.StoryNavigationDestination
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

/**
 * Created by Julsapargi Nursam on 5/21/22.
 * Mobile Engineer - Android
 */

object HomeNavigation {
    val home = object : StoryNavigationDestination {
        override val route: String
            get() = "route_home"
        override val destination: String
            get() = "destination_home"
    }

    val detail = object : StoryNavigationDestination {
        override val route: String
            get() = "route_detail_home/"
        override val destination: String
            get() = "destination_detail_home"
    }
}

fun NavGraphBuilder.homeGraph(
    navController: NavController
) {
    navigation(
        startDestination = HomeNavigation.home.route,
        route = "destination_splash"
    ) {
        composable(
            route = HomeNavigation.home.route
        ) {
            HomeRoute(
                navigationToLogin = {
                    navController.navigate(
                        route = "login_route"
                    ) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            inclusive = true
                        }
                    }
                },
                navigationToDetail = {
                    val encodedUrl = URLEncoder.encode(it.photoUrl, StandardCharsets.UTF_8.toString())

                    navController.navigate(
                        route = "${HomeNavigation.detail.route}${it.name}/${encodedUrl}/${it.description}",
                    ) {
                        popUpTo(
                            route = HomeNavigation.home.route
                        )
                    }
                }
            )
        }

        composable(
            route = HomeNavigation.detail.route + "{name}/{photos}/{description}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                },
                navArgument("photos") {
                    type = NavType.StringType
                },
                navArgument("description") {
                    type = NavType.StringType
                }
            )
        ) {
            val photos = it.arguments?.getString("photos", "") ?: ""
            val decodedUrl = URLDecoder.decode(photos, StandardCharsets.UTF_8.toString())

            DetailStoryRoute(
                name = it.arguments?.getString("name", "") ?: "",
                photos = decodedUrl,
                description = it.arguments?.getString("description", "") ?: "",
                onBackPressed = {
                    navController.popBackStack()
                }
            )
        }
    }
}