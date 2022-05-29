package id.buaja.navigation

import id.buaja.navigation.utils.StoryNavigationDestination

/**
 * Created by Julsapargi Nursam on 5/29/22.
 * Mobile Engineer - Android
 */

object StoryNavigation {
    val addNewStory = object : StoryNavigationDestination {
        override val route: String
            get() = "add_new_story_route"
        override val destination: String
            get() = "add_new_story_destination"

    }
}