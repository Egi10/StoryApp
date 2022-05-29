package id.buaja.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import id.buaja.ui.R

/**
 * Created by Julsapargi Nursam on 5/28/22.
 * Mobile Engineer - Android
 */

/**
 * @param title The title to be displayed in the center of the TopAppBar
 * @param navigationIcon Icon to be displayed for navigation
 * @param navigationIconEnable To enable or not icon navigation
 * @param onNavigationClick the lambda to be invoked when this [navigationIcon] is pressed
 */

@Composable
fun StoryTopBar(
    title: String,
    navigationIconEnable: Boolean = false,
    @DrawableRes navigationIcon: Int = R.drawable.ic_baseline_arrow_back_24,
    onNavigationClick: () -> Unit
) {
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth(),
        title = {
            Text(
                text = title
            )
        },
        navigationIcon = if (navigationIconEnable) {
            {
                IconButton(
                    onClick = onNavigationClick
                ) {
                    Icon(
                        painter = painterResource(id = navigationIcon),
                        contentDescription = null
                    )
                }
            }
        } else {
            null
        }
    )
}

@Preview
@Composable
private fun StoryTopBarPreview() {
    StoryTopBar(
        title = "New Story"
    ) {

    }
}