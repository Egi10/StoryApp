package id.buaja.maps.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import id.buaja.maps.R
import id.buaja.maps.ui.model.MapsUiState

/**
 * Created by Julsapargi Nursam on 20/06/22
 * Mobile Engineer - Android
 */

@Composable
fun MapsScreen(
    mapsUiState: MapsUiState,
    lat: Double,
    long: Double
) {
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(LatLng(lat, long), 12f)
    }

    GoogleMap(
        modifier = Modifier
            .fillMaxSize(),
        cameraPositionState = cameraPositionState,
    ) {
        mapsUiState.data.forEach {
            val latLng = LatLng(it.lat, it.lon)
            Marker(
                position = latLng,
                title = it.name,
                snippet = stringResource(R.string.marker_in, it.name),
            )
        }
    }
}

@Preview
@Composable
private fun MapsScreenPreview() {
    MapsScreen(
        mapsUiState = MapsUiState(),
        lat = 0.0,
        long = 0.0
    )
}