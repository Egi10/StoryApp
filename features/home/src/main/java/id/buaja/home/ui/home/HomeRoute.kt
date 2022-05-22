package id.buaja.home.ui.home

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import id.buaja.home.domain.model.Story

/**
 * Created by Julsapargi Nursam on 5/21/22.
 * Mobile Engineer - Android
 */

@Composable
fun HomeRoute(
    viewModel: HomeViewModel = hiltViewModel(),
    navigationToLogin: () -> Unit,
    navigationToDetail: (Story) -> Unit
) {
    val story = viewModel.getStory().collectAsLazyPagingItems()

    HomeScreen(
        story = story,
        navigationToLogin = {
            viewModel.clearToken()
            navigationToLogin.invoke()
        },
        navigationToDetail = navigationToDetail
    )
}