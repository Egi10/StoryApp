package id.buaja.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Created by Julsapargi Nursam on 5/21/22.
 * Mobile Engineer - Android
 */

/**
 * @param onClick Will be called when the user clicks the button
 * @param modifier Modifier to be applied to the button
 * @param text The text to be displayed.
 * @param enabled Controls the enabled state of the button. When `false`, this button will not
 * be clickable
 */

@Composable
fun StoryButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    enabled: Boolean = false
) {
    Button(
        modifier = modifier
            .sizeIn(
                minHeight = 56.dp
            ),
        onClick = onClick,
        enabled = enabled
    ) {
        Text(
            text = text,
            fontSize = 16.sp
        )
    }
}

@Preview
@Composable
private fun StoryButtonPreview() {
    StoryButton(
        modifier = Modifier
            .fillMaxWidth(),
        onClick = {  },
        text = "Sign Up"
    )
}