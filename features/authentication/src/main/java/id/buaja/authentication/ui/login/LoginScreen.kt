package id.buaja.authentication.login.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.buaja.authentication.R
import id.buaja.authentication.ui.components.TextBar
import id.buaja.ui.components.StoryButton
import id.buaja.ui.components.StoryOutlinedTextField
import id.buaja.ui.extensions.Space
import id.buaja.ui.thema.Purple700

/**
 * Created by Julsapargi Nursam on 5/21/22.
 * Mobile Engineer - Android
 */

@Composable
fun LoginScreen(
    navigationToSignUp: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Space(height = 24.dp)

        TextBar(
            title = stringResource(R.string.welcome_back),
            description = stringResource(R.string.message_welcome_back)
        )

        Space(height = 24.dp)

        StoryOutlinedTextField(
            value = "",
            onValueChange = { },
            label = stringResource(id = R.string.email),
            placeholder = stringResource(id = R.string.placeholder_email)
        )

        Space(height = 10.dp)

        StoryOutlinedTextField(
            value = "",
            onValueChange = {},
            label = stringResource(id = R.string.password),
            placeholder = stringResource(id = R.string.placeholder_password)
        )

        Space(height = 24.dp)

        StoryButton(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = { },
            text = stringResource(R.string.sign_in)
        )

        Space(height = 5.dp)

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.dont_account),
                fontSize = 12.sp
            )

            Space(width = 5.dp)

            ClickableText(
                text = AnnotatedString(stringResource(R.string.create_now)),
                onClick = navigationToSignUp,
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Purple700,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}

@Preview(
    device = Devices.PIXEL_2,
    showBackground = true,
)
@Composable
private fun LoginScreenPreview() {
    LoginScreen(
        navigationToSignUp = { }
    )
}