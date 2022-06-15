package id.buaja.story.ui.add

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Environment
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.hilt.navigation.compose.hiltViewModel
import id.buaja.story.ui.add.model.AddNewStoryEventState
import id.buaja.story.ui.add.model.AddNewStoryUiState
import id.buaja.ui.extensions.toast
import java.io.File

/**
 * Created by Julsapargi Nursam on 5/28/22.
 * Mobile Engineer - Android
 */

@Composable
fun AddNewStoryRoute(
    viewModel: AddNewStoryViewModel = hiltViewModel(),
    onSuccessUpload: () -> Unit,
    onBackPressed: () -> Unit
) {
    val context = LocalContext.current
    var uri: Uri = Uri.EMPTY

    val uiState = viewModel.uiState.collectAsState()

    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture(),
        onResult = {
            if (it == true) {
                viewModel.onEvent(
                    event = AddNewStoryEventState.PhotoChanged(
                        uri = uri
                    )
                )
            }
        }
    )

    val requestPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = {
            if (it == true) {
                uri = getTmpFileUri(
                    context = context
                )
                cameraLauncher.launch(
                    uri
                )
            }
        }
    )

    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = {
            viewModel.onEvent(
                event = AddNewStoryEventState.PhotoChanged(
                    uri = it
                )
            )
        }
    )

    LaunchedEffect(
        key1 = uiState.value.addNewStoryState,
        block = {
            when (val addNewStoryState = uiState.value.addNewStoryState) {
                is AddNewStoryUiState.Success -> {
                    context.toast(
                        addNewStoryState.addNewStory.message
                    )
                    onSuccessUpload.invoke()
                }

                is AddNewStoryUiState.Error -> {
                    context.toast(
                        addNewStoryState.exception.toString()
                    )
                }

                else -> {}
            }
        }
    )

    AddNewStoryScreen(
        onBackPressed = onBackPressed,
        descriptionValue = uiState.value.description,
        onDescriptionValueChange = {
            viewModel.onEvent(
                event = AddNewStoryEventState.DescriptionsChanged(
                    description = it
                )
            )
        },
        onCameraClick = {
            when {
                ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.CAMERA
                ) == PackageManager.PERMISSION_GRANTED -> {
                    uri = getTmpFileUri(
                        context = context
                    )
                    cameraLauncher.launch(
                        uri
                    )
                }

                ActivityCompat.shouldShowRequestPermissionRationale(
                    context as Activity,
                    Manifest.permission.CAMERA
                ) -> {
                    Log.i("kilo", "Show camera permissions dialog")
                }

                else -> {
                    requestPermissionLauncher.launch(Manifest.permission.CAMERA)
                }
            }
        },
        onGalleryClick = {
            galleryLauncher.launch("image/*")
        },
        onUploadClick = {
            viewModel.onEvent(
                event = AddNewStoryEventState.Upload
            )
        },
        uri = uiState.value.photo,
        loadingUpload = uiState.value.loading,
        enableUpload = viewModel.isEnableUpload()
    )
}

private fun getTmpFileUri(context: Context): Uri {
    val tmpFile = File.createTempFile(
        "tmp_image_file",
        ".png",
        context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
    ).apply {
        createNewFile()
        deleteOnExit()
    }
    return FileProvider.getUriForFile(
        context,
        "id.buaja.storyapp.provider",
        tmpFile
    )
}