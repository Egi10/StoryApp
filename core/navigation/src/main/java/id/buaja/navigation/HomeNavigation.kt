package id.buaja.navigation

import id.buaja.navigation.utils.StoryNavigationDestination

/**
 * Created by Julsapargi Nursam on 6/1/22.
 * Mobile Engineer - Android
 */

object HomeNavigation {
    const val route = "root_route_home"

    val home = object : StoryNavigationDestination {
        override val route: String
            get() = "route_home"
        override val destination: String
            get() = "destination_home"
    }

    val detail = object : StoryNavigationDestination {
        override val route: String
            get() = "route_detail_home"
        override val destination: String
            get() = "destination_detail_home"
    }
}