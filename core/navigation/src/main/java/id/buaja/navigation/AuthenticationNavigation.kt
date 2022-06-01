package id.buaja.navigation

import id.buaja.navigation.utils.StoryNavigationDestination

/**
 * Created by Julsapargi Nursam on 6/1/22.
 * Mobile Engineer - Android
 */

object AuthenticationNavigation {
    const val route = "root_login_route"

    val login = object : StoryNavigationDestination {
        override val route: String
            get() = "login_route"
        override val destination: String
            get() = "login_destination"
    }

    val register = object : StoryNavigationDestination {
        override val route: String
            get() = "register_route"
        override val destination: String
            get() = "register_destination"
    }
}