package id.buaja.story.ui.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemsIndexed
import id.buaja.story.R
import id.buaja.story.domain.model.Story
import id.buaja.story.ui.list.component.HomeTopAppBar
import id.buaja.story.ui.list.component.LoadingItem
import id.buaja.story.ui.list.component.StoryItem
import id.buaja.ui.extensions.Space

/**
 * Created by Julsapargi Nursam on 5/21/22.
 * Mobile Engineer - Android
 */

@Composable
internal fun ListStoryScreen(
    story: LazyPagingItems<Story>,
    navigationToLogin: () -> Unit,
    navigationToDetail: (Story) -> Unit,
    navigationToAddNewStory: () -> Unit,
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            HomeTopAppBar(
                title = stringResource(R.string.home),
                titleColors = Color.Black,
                actionIcons = R.drawable.ic_baseline_login_24,
                tintActionIcons = Color.Gray,
                onClickActions = {
                    navigationToLogin.invoke()
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = navigationToAddNewStory,
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_add_24),
                        contentDescription = null,
                        tint = Color.White
                    )
                },
                backgroundColor = MaterialTheme.colors.primaryVariant
            )
        },
        content = {
            LazyColumn(
                contentPadding = PaddingValues(
                    top = 16.dp,
                    bottom = 16.dp
                ),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                content = {
                    itemsIndexed(
                        key = { _, item ->
                            item.id
                        },
                        items = story
                    ) { index, value ->
                        StoryItem(
                            item = value,
                            position = index,
                            onClick = {
                                navigationToDetail.invoke(it)
                            }
                        )

                        Space(size = 16.dp)

                        Divider()
                    }

                    /**
                     * Handle Loading And Error Message
                     */
                    story.apply {
                        when {
                            loadState.refresh is LoadState.Loading || loadState.append is LoadState.Loading -> {
                                item {
                                    LoadingItem()
                                }
                            }

                            loadState.refresh is LoadState.Error || loadState.append is LoadState.Error -> {
                                // Error Handle
                            }
                        }
                    }
                }
            )
        }
    )
}