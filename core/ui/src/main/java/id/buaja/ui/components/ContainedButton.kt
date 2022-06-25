package id.buaja.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import id.buaja.ui.extensions.Space

/**
 * Created by Julsapargi Nursam on 25/06/22
 * Mobile Engineer - Android
 */

@Composable
fun StoryContainedButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    shape: Shape = MaterialTheme.shapes.small,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    @DrawableRes leadingIcon: Int? = null,
    paddingLeadingIcon: Dp = 16.dp,
    text: String,
    color: Color = Color.Unspecified,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = shape,
        colors = colors
    ) {
        if (leadingIcon != null) {
            Icon(
                painter = painterResource(id = leadingIcon),
                contentDescription = null,
                tint = color
            )

            Space(width = paddingLeadingIcon)
        }

        Text(
            text = text,
            color = color
        )
    }
}

@Preview
@Composable
private fun StoryContainedButton() {
    StoryContainedButton(
        onClick = {  },
        text = "Add Story"
    )
}