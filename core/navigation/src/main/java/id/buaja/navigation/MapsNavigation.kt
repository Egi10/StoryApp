package id.buaja.navigation

import id.buaja.navigation.utils.StoryNavigationDestination

/**
 * Created by Julsapargi Nursam on 20/06/22
 * Mobile Engineer - Android
 */

object MapsNavigation : StoryNavigationDestination {
    override val route: String
        get() = "maps_route"
    override val destination: String
        get() = "maps_destination"
}