package id.buaja.home.ui.detail

import androidx.compose.runtime.Composable

/**
 * Created by Julsapargi Nursam on 5/22/22.
 * Mobile Engineer - Android
 */

@Composable
fun DetailStoryRoute(
    name: String,
    photos: String,
    description: String,
    onBackPressed: () -> Unit
) {
    DetailStoryScreen(
        name = name,
        photos = photos,
        description = description,
        onBackPressed = onBackPressed
    )
}