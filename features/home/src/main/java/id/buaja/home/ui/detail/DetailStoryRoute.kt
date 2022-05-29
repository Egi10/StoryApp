package id.buaja.home.ui.detail

import androidx.compose.runtime.Composable
import id.buaja.home.domain.model.Story

/**
 * Created by Julsapargi Nursam on 5/22/22.
 * Mobile Engineer - Android
 */

@Composable
fun DetailStoryRoute(
    story: Story,
    onBackPressed: () -> Unit
) {
    DetailStoryScreen(
        story = story,
        onBackPressed = onBackPressed
    )
}