package id.buaja.navigation

import id.buaja.navigation.utils.StoryNavigationDestination

/**
 * Created by Julsapargi Nursam on 5/29/22.
 * Mobile Engineer - Android
 */

object StoryNavigation {
    val list = object : StoryNavigationDestination {
        override val route: String
            get() = "story_route"
        override val destination: String
            get() = "story_destination"
    }

    val detail = object : StoryNavigationDestination {
        override val route: String
            get() = "detail_story_route"
        override val destination: String
            get() = "detail_story_destination"
    }

    val addNewStory = object : StoryNavigationDestination {
        override val route: String
            get() = "add_new_story_route"
        override val destination: String
            get() = "add_new_story_destination"

    }
}