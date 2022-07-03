package id.buaja.story.ui.list

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import id.buaja.story.domain.model.Story
import id.buaja.ui.extensions.collectAsLazyPagingItemsLifecycleAware

/**
 * Created by Julsapargi Nursam on 5/21/22.
 * Mobile Engineer - Android
 */

@Composable
fun ListStoryRoute(
    viewModel: ListStoryViewModel = hiltViewModel(),
    navigationToLogin: () -> Unit,
    navigationToDetail: (Story) -> Unit,
    navigationToAddNewStory: () -> Unit,
) {
    val story = viewModel.getStory().collectAsLazyPagingItemsLifecycleAware()

    ListStoryScreen(
        story = story,
        navigationToLogin = {
            viewModel.clearToken()
            navigationToLogin.invoke()
        },
        navigationToDetail = navigationToDetail,
        navigationToAddNewStory = navigationToAddNewStory
    )
}