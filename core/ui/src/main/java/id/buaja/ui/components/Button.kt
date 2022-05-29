package id.buaja.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
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
 * @param minHeight To set the button height
 * @param fontSize The size of glyphs to use when painting the text.
 * @param shape Defines the button's shape as well as its shadow
 */

@Composable
fun StoryButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    enabled: Boolean = false,
    loading: Boolean = false,
    minHeight: Dp = 56.dp,
    fontSize: TextUnit = 16.sp,
    shape: Shape = MaterialTheme.shapes.small
) {
    Button(
        modifier = modifier
            .sizeIn(
                minHeight = minHeight
            ),
        onClick = onClick,
        enabled = enabled,
        shape = shape,
        content = {
            if (loading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(24.dp),
                    color = Color.White
                )
            } else {
                Text(
                    text = text,
                    fontSize = fontSize
                )
            }
        }
    )
}

@Preview
@Composable
private fun StoryButtonPreview() {
    StoryButton(
        modifier = Modifier
            .fillMaxWidth(),
        onClick = { },
        text = "Sign Up"
    )
}

@Preview
@Composable
private fun StoryButtonLoadingPreview() {
    StoryButton(
        modifier = Modifier
            .fillMaxWidth(),
        onClick = { },
        text = "Sign Up",
        loading = true
    )
}