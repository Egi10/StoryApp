package id.buaja.story.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import id.buaja.story.ui.add.AddNewStoryRoute
import id.buaja.navigation.StoryNavigation

/**
 * Created by Julsapargi Nursam on 5/29/22.
 * Mobile Engineer - Android
 */

fun NavGraphBuilder.storyGraph(
    navigationToHome: () -> Unit,
    onBackPressed: () -> Unit
) {

    composable(
        route = StoryNavigation.addNewStory.route
    ) {
        AddNewStoryRoute(
            onSuccessUpload = navigationToHome,
            onBackPressed = onBackPressed
        )
    }
}