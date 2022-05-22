package id.buaja.home.ui.home.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.buaja.ui.extensions.Space

/**
 * Created by Julsapargi Nursam on 5/22/22.
 * Mobile Engineer - Android
 */

@Composable
fun HomeTopAppBar(
    title: String,
    titleColors: Color = MaterialTheme.colors.primaryVariant,
    @DrawableRes actionIcons: Int? = null,
    tintActionIcons: Color = Color.Unspecified,
    onClickActions: (() -> Unit)? = null,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Space(width = 16.dp)

            Text(
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .weight(1f),
                color = titleColors
            )

            if (actionIcons != null) {
                IconButton(
                    onClick = {
                        onClickActions?.invoke()
                    },
                    content = {
                        Icon(
                            painter = painterResource(id = actionIcons),
                            contentDescription = null,
                            tint = tintActionIcons
                        )
                    }
                )
            }
        }

        Divider()
    }
}