package id.buaja.home.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemsIndexed
import id.buaja.home.R
import id.buaja.home.domain.model.Story
import id.buaja.home.ui.home.components.HomeTopAppBar
import id.buaja.home.ui.home.components.LoadingItem
import id.buaja.home.ui.home.components.StoryItem
import id.buaja.ui.extensions.Space

/**
 * Created by Julsapargi Nursam on 5/21/22.
 * Mobile Engineer - Android
 */

@Composable
fun HomeScreen(
    story: LazyPagingItems<Story>,
    navigationToLogin: () -> Unit,
    navigationToDetail: (Story) -> Unit,
    navigationToAddNewStory: () -> Unit,
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
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
            Column {
                HomeTopAppBar(
                    title = stringResource(R.string.home),
                    titleColors = Color.Black,
                    actionIcons = R.drawable.ic_baseline_login_24,
                    tintActionIcons = Color.Gray,
                    onClickActions = {
                        navigationToLogin.invoke()
                    }
                )

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
        }
    )
}