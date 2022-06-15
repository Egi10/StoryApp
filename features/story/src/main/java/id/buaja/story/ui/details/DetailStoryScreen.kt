package id.buaja.story.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import id.buaja.story.domain.model.Story
import id.buaja.story.ui.list.component.LoadingItem
import id.buaja.ui.extensions.Space
import id.buaja.story.R

/**
 * Created by Julsapargi Nursam on 5/22/22.
 * Mobile Engineer - Android
 */

@Composable
fun DetailStoryScreen(
    story: Story,
    onBackPressed: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 32.dp,
                start = 24.dp,
                end = 24.dp
            ),
    ) {
        IconButton(
            onClick = onBackPressed,
            modifier = Modifier
                .size(32.dp)
                .clip(
                    CircleShape
                )
                .background(
                    color = Color.Gray
                )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_arrow_back_24),
                contentDescription = null,
                tint = Color.White
            )
        }

        LazyColumn(
            contentPadding = PaddingValues(
                top = 24.dp
            ),
            content = {
                item {
                    Text(
                        text = story.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )

                    Text(
                        text = story.description
                    )

                    Space(size = 16.dp)

                    SubcomposeAsyncImage(
                        model = story.photoUrl,
                        contentDescription = null,
                        loading = {
                            LoadingItem()
                        },
                    )
                }
            }
        )
    }
}