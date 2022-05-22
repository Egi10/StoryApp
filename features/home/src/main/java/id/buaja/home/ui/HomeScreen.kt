package id.buaja.home.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import id.buaja.home.R

/**
 * Created by Julsapargi Nursam on 5/21/22.
 * Mobile Engineer - Android
 */

@Composable
fun HomeScreen(
    navigationToLogin: (Int) -> Unit
) {
    var showMenu by remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Home"
                    )
                },
                actions = {
                    IconButton(onClick = { showMenu = !showMenu }) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = null
                        )
                    }
                    DropdownMenu(
                        expanded = showMenu,
                        onDismissRequest = {
                            showMenu = false
                        },
                        offset = DpOffset(
                            x = 10.dp,
                            y = (-10).dp
                        )
                    ) {
                        ClickableText(
                            text = AnnotatedString(text = stringResource(R.string.log_out)),
                            modifier = Modifier.padding(
                                start = 30.dp,
                                end = 30.dp
                            ),
                            onClick = {
                                showMenu = false
                                navigationToLogin.invoke(it)
                            }
                        )
                    }
                }
            )
        }
    ) {

    }
}