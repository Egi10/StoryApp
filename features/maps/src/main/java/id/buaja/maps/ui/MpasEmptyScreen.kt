package id.buaja.maps.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.buaja.maps.R
import id.buaja.ui.components.StoryContainedButton
import id.buaja.ui.extensions.Space
import id.buaja.ui.thema.StoryAppTheme

/**
 * Created by Julsapargi Nursam on 25/06/22
 * Mobile Engineer - Android
 */

@Composable
fun MapsEmptyScreen(
    onNavigationToAddStory: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.page),
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
        )

        Space(height = 32.dp)

        Text(
            text = "No Story Today",
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Space(height = 8.dp)

        Text(
            text = "Come on, add your story today. Let your friends know if you're happy today or you're sad, come on, write your story",
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth(fraction = 0.7f)
        )

        Space(height = 16.dp)

        StoryContainedButton(
            onClick = onNavigationToAddStory,
            text = "Add Story",
            leadingIcon = R.drawable.ic_baseline_add_24,
            shape = RoundedCornerShape(24.dp),
            color = Color.White
        )
    }
}

@Preview(
    showBackground = true,
    device = Devices.PIXEL
)
@Composable
private fun MapsEmptyScreenPreview() {
    StoryAppTheme {
        MapsEmptyScreen(
            onNavigationToAddStory = { }
        )
    }
}