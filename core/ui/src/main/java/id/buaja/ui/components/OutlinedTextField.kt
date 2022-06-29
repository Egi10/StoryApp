package id.buaja.ui.components

import android.util.Patterns
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.buaja.ui.R

/**
 * Created by Julsapargi Nursam on 5/20/22.
 * Mobile Engineer - Android
 */

/**
 * @param value the input text to be shown in the text field
 * @param onValueChange the callback that is triggered when the input service updates the text. An
 * updated text comes as a parameter of the callback
 * @param isError indicates if the text field's current value is in error. If set to true, the
 * label, bottom indicator and trailing icon by default will be displayed in error color
 * @param label the optional label to be displayed inside the text field container.
 * @param placeholder the optional placeholder to be displayed when the text field is in focus and
 * the input text is empty.
 * @param errorMessage optional label to return when isError equals true.
 * @param inputType the desired input type in the textField.
 * @param onValidation to validate whether it is in accordance with validation or not.
 */

@Composable
fun StoryOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    isError: Boolean = false,
    errorMessage: String = "",
    inputType: InputType = InputType.none,
    onValidation: ((Boolean) -> Unit)? = null
) {
    var passwordVisibility by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = value,
            onValueChange = {
                when (inputType) {
                    InputType.email -> {
                        onValidation?.invoke(isErrorValidationEmail(it))
                    }

                    InputType.password -> {
                        onValidation?.invoke(isErrorValidationPassword(it))
                    }

                    InputType.none -> {
                        // No validation
                    }
                }
                onValueChange.invoke(it)
            },
            label = {
                Text(
                    text = label
                )
            },
            placeholder = {
                Text(
                    text = placeholder
                )
            },
            isError = isError,
            visualTransformation = when (inputType) {
                InputType.email -> {
                    VisualTransformation.None
                }

                InputType.password -> {
                    if (passwordVisibility) {
                        VisualTransformation.None
                    } else {
                        PasswordVisualTransformation()
                    }
                }

                else -> {
                    VisualTransformation.None
                }
            },
            trailingIcon = if (inputType == InputType.password) {
                {
                    TrailingIconPassword(
                        passwordVisibility = passwordVisibility,
                        onClick = {
                            passwordVisibility = !passwordVisibility
                        }
                    )
                }
            } else {
                null
            }
        )

        if (isError) {
            ErrorText(
                errorMessage = errorMessage
            )
        }
    }
}

@Composable
private fun ErrorText(errorMessage: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 2.dp,
                start = 15.dp
            ),
        text = errorMessage,
        color = MaterialTheme.colors.error,
        fontSize = 12.sp
    )
}

@Composable
private fun TrailingIconPassword(
    passwordVisibility: Boolean,
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick
    ) {
        val image = if (passwordVisibility) {
            R.drawable.ic_visibility_24
        } else {
            R.drawable.ic_visibility_off_24
        }

        Icon(
            painter = painterResource(id = image),
            contentDescription = null
        )
    }
}

class InputType {
    companion object {
        val none: InputType = InputType()
        val email: InputType = InputType()
        val password: InputType = InputType()
    }
}

fun isErrorValidationEmail(email: String): Boolean {
    return if (email.isEmpty()) {
        false
    } else !Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

fun isErrorValidationPassword(password: String): Boolean {
    return if (password.isEmpty()) {
        false
    } else password.length < 6
}

@Preview(showBackground = true)
@Composable
private fun StoryOutlinedTextFieldPreview() {
    StoryOutlinedTextField(
        value = "",
        onValueChange = { },
        label = "Email",
        placeholder = "Masukkan Email Anda",
        errorMessage = "Masukan Email Dengan Benar",
        isError = true
    )
}

@Preview(showBackground = true)
@Composable
private fun StoryOutlinedTextFieldErrorFalsePreview() {
    StoryOutlinedTextField(
        value = "",
        onValueChange = { },
        label = "Email",
        placeholder = "Masukkan Email Anda",
        errorMessage = "Masukan Email Dengan Benar",
        isError = false
    )
}