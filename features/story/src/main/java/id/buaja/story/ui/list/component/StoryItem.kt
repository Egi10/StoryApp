package id.buaja.story.ui.list.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import id.buaja.story.domain.model.Story
import id.buaja.story.ui.component.InitialsImage
import id.buaja.ui.extensions.Space
import id.buaja.ui.extensions.formatDate
import id.buaja.story.R

/**
 * Created by Julsapargi Nursam on 5/22/22.
 * Mobile Engineer - Android
 */

@Composable
fun StoryItem(
    item: Story?,
    position: Int,
    onClick: (Story) -> Unit
) {
    Row(
        modifier = Modifier
            .clickable {
                item?.let { onClick.invoke(it) }
            }
            .padding(
                start = 8.dp,
                end = 8.dp
            )
            .fillMaxWidth()
    ) {
        InitialsImage(
            text = item?.name ?: "",
            position = position
        )

        Space(width = 8.dp)

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            TextInline(
                firstText = item?.name ?: "",
                secondText = item?.createdAt?.formatDate() ?: ""
            )

            Text(
                text = item?.description ?: ""
            )

            if (!item?.photoUrl.isNullOrEmpty()) {
                Space(height = 5.dp)

                SubcomposeAsyncImage(
                    model = item?.photoUrl,
                    loading = {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .size(24.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    },
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(
                            RoundedCornerShape(8.dp)
                        ),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@Composable
fun TextInline(
    firstText: String,
    secondText: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = firstText,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .weight(
                    weight = 1f,
                    fill = false
                )
        )

        Space(width = 5.dp)

        Icon(
            painter = painterResource(id = R.drawable.ic_round_brightness_1_24),
            contentDescription = null,
            tint = Color.Gray,
            modifier = Modifier
                .size(2.dp)
        )

        Space(width = 5.dp)

        Text(
            text = secondText,
            color = Color.Gray,
            maxLines = 1,
            fontSize = 12.sp,
        )
    }
}