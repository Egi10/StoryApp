package id.buaja.add_new_story.ui.add

import android.net.Uri
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import id.buaja.add_new_story.R
import id.buaja.ui.components.StoryButton
import id.buaja.ui.components.StoryTopBar
import id.buaja.ui.extensions.Space

/**
 * Created by Julsapargi Nursam on 5/28/22.
 * Mobile Engineer - Android
 */

@Composable
fun AddNewStoryScreen(
    onBackPressed: () -> Unit,
    descriptionValue: String,
    onDescriptionValueChange: (String) -> Unit,
    onCameraClick: () -> Unit,
    onGalleryClick: () -> Unit,
    onUploadClick: (Uri?) -> Unit,
    uri: Uri? = null,
    loadingUpload: Boolean = false,
    enableUpload: Boolean = false
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            StoryTopBar(
                title = stringResource(R.string.new_story),
                onNavigationClick = onBackPressed,
                navigationIconEnable = true
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 24.dp,
                        start = 32.dp,
                        end = 32.dp
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                StoryImage(
                    image = R.drawable.bg_image_not_found,
                    uri = uri
                )

                Space(height = 8.dp)

                Row {
                    StoryButton(
                        onClick = onCameraClick,
                        text = stringResource(R.string.camera),
                        minHeight = 24.dp,
                        fontSize = 12.sp,
                        shape = RoundedCornerShape(16.dp),
                        enabled = true
                    )

                    Space(width = 5.dp)

                    StoryButton(
                        onClick = onGalleryClick,
                        text = stringResource(R.string.gallery),
                        minHeight = 24.dp,
                        fontSize = 12.sp,
                        shape = RoundedCornerShape(16.dp),
                        enabled = true
                    )
                }

                Space(height = 16.dp)

                OutlinedTextField(
                    value = descriptionValue,
                    onValueChange = onDescriptionValueChange,
                    placeholder = {
                        Text(
                            text = stringResource(R.string.placeholder_description),
                            fontSize = 12.sp,
                            color = Color.Gray
                        )
                    },
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .sizeIn(
                            minHeight = 150.dp
                        )
                )

                Space(height = 16.dp)

                StoryButton(
                    onClick = {
                        onUploadClick.invoke(uri)
                    },
                    text = "Upload",
                    minHeight = 24.dp,
                    fontSize = 12.sp,
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxWidth(),
                    enabled = enableUpload,
                    loading = loadingUpload
                )
            }
        }
    )
}

@Composable
fun StoryImage(
    @DrawableRes image: Int? = null,
    uri: Uri? = null
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
    ) {
        Image(
            painter = if (uri != Uri.EMPTY) {
                rememberAsyncImagePainter(
                    model = uri,
                )
            } else {
                painterResource(id = image ?: 0)
            },
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(150.dp)
        )
    }
}

@Preview(
    device = Devices.PIXEL,
    showBackground = true,
)
@Composable
private fun AddNewStoryScreenPreview() {
    AddNewStoryScreen(
        onBackPressed = { },
        descriptionValue = "",
        onDescriptionValueChange = { },
        onCameraClick = { },
        onGalleryClick = { },
        onUploadClick = { }
    )
}