package id.buaja.navigation

import id.buaja.navigation.utils.StoryNavigationDestination

/**
 * Created by Julsapargi Nursam on 6/1/22.
 * Mobile Engineer - Android
 */

object SplashNavigation : StoryNavigationDestination {
    override val route: String
        get() = "route_splash"
    override val destination: String
        get() = "destination_splash"
}