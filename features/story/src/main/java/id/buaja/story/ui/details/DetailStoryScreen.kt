package id.buaja.story.ui.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import id.buaja.story.R
import id.buaja.story.domain.model.Story
import id.buaja.story.ui.list.component.LoadingItem
import id.buaja.ui.components.StoryTopBar
import id.buaja.ui.extensions.Space
import id.buaja.ui.extensions.formatDate

/**
 * Created by Julsapargi Nursam on 5/22/22.
 * Mobile Engineer - Android
 */

@Composable
internal fun DetailStoryScreen(
    story: Story,
    onBackPressed: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        StoryTopBar(
            title = stringResource(R.string.story_details),
            navigationIconEnable = true,
            onNavigationClick = onBackPressed
        )

        LazyColumn(
            contentPadding = PaddingValues(
                all = 24.dp
            ),
            content = {
                item {
                    SubcomposeAsyncImage(
                        model = story.photoUrl,
                        contentDescription = null,
                        loading = {
                            LoadingItem()
                        },
                    )

                    Space(size = 16.dp)

                    Text(
                        text = story.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )

                    Text(
                        text = story.createdAt.formatDate(),
                        fontWeight = FontWeight.Light,
                        fontSize = 12.sp
                    )

                    Space(size = 24.dp)

                    Text(
                        text = story.description
                    )
                }
            }
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun DetailStoryScreenPreview() {
    DetailStoryScreen(
        story = Story(
            createdAt = "26 Juni 2022",
            description = """
                In publishing and graphic design, Lorem ipsum is a placeholder text commonly 
                used to demonstrate the visual form of a document or a typeface without relying 
                on meaningful content. Lorem ipsum may be used as a placeholder before 
                final copy is available.
            """.trimIndent(),
            id = "1",
            lat = 0.0,
            lon = 0.0,
            name = "Lorem ipsum",
            photoUrl = "https://designingminds.files.wordpress.com/2016/03/lorem-ipsum.jpg"
        ),
        onBackPressed = { }
    )
}