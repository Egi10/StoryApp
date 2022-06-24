package id.buaja.common

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.os.Looper
import android.util.Log
import androidx.lifecycle.LiveData
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices

/**
 * Created by Julsapargi Nursam on 23/06/22
 * Mobile Engineer - Android
 */

class LocationLiveData(context: Context) : LiveData<LocationsDetails>() {
    private val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)

    @SuppressLint("MissingPermission")
    override fun onActive() {
        super.onActive()
        fusedLocationClient.lastLocation.addOnSuccessListener {
            it.also {
                Log.d("eror", "${it.longitude} - ${it.latitude}")
                value = setLocationData(it)
            }
        }
        startLocationUpdate()
    }

    override fun onInactive() {
        super.onInactive()
        fusedLocationClient.removeLocationUpdates(locationCallback)
    }

    @SuppressLint("MissingPermission")
    fun startLocationUpdate() {
        fusedLocationClient.requestLocationUpdates(
            locationRequest,
            locationCallback,
            Looper.getMainLooper()
        )
    }

    private fun setLocationData(location: Location?): LocationsDetails {
        return LocationsDetails(
            latitude = location?.latitude ?: 0.0,
            longitude = location?.longitude ?: 0.0
        )
    }

    private val locationCallback = object : LocationCallback() {
        override fun onLocationResult(p0: LocationResult) {
            super.onLocationResult(p0)

            p0 ?: return

            for (location in p0.locations) {
                setLocationData(location)
            }
        }
    }

    companion object {
        val ONE_MINUTE: Long = 60_0000
        val locationRequest = LocationRequest.create().apply {
            interval = ONE_MINUTE
            fastestInterval = ONE_MINUTE / 4
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }
    }
}

data class LocationsDetails(
    val latitude: Double,
    val longitude: Double
)