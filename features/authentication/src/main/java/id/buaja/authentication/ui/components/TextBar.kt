package id.buaja.authentication.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.buaja.ui.extensions.Space

/**
 * Created by Julsapargi Nursam on 5/21/22.
 * Mobile Engineer - Android
 */

/**
 * @param title The text to be displayed on the title.
 * @param description The text to be displayed on the description.
 */

@Composable
internal fun TextBar(
    title: String,
    description: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(
            text = title,
            fontSize = 32.sp
        )

        Space(height = 5.dp)

        Text(
            text = description,
            fontSize = 18.sp
        )
    }
}