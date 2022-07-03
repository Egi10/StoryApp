package id.buaja.maps.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import id.buaja.ui.extensions.collectAsStateLifecycleAware
import id.buaja.ui.extensions.toast

/**
 * Created by Julsapargi Nursam on 20/06/22
 * Mobile Engineer - Android
 */

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MapsRoute(
    viewModel: MapsViewModel = hiltViewModel(),
    onNavigationToAddStory: () -> Unit,
) {
    val context = LocalContext.current
    val uiState = viewModel.uiState.collectAsStateLifecycleAware().value
    val locationState = viewModel.locationState.observeAsState()

    val locationPermissionsState = rememberMultiplePermissionsState(
        permissions = listOf(
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION,
        ),
        onPermissionsResult = {
            if (it.isNotEmpty()) {
                viewModel.startLocationUpdate()
            } else {
                val message = context.getString(id.buaja.ui.R.string.not_permission)
                context.toast(message)
            }
        }
    )

    LaunchedEffect(
        key1 = locationPermissionsState,
        block = {
            locationPermissionsState.launchMultiplePermissionRequest()
        }
    )

    if (uiState.loading) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(32.dp)
            )
        }
    }

    if (uiState.data.isNotEmpty()) {
        MapsScreen(
            mapsUiState = uiState,
            lat = locationState.value?.latitude ?: uiState.data[0].lat,
            long = locationState.value?.longitude ?: uiState.data[0].lon
        )
    }

    if (uiState.isEmpty) {
        MapsEmptyScreen(
            onNavigationToAddStory = onNavigationToAddStory
        )
    }

    if (uiState.error.isNotEmpty()) {
        Text(
            text = uiState.error
        )
    }
}