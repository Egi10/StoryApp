package id.buaja.home.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by Julsapargi Nursam on 5/22/22.
 * Mobile Engineer - Android
 */

@Parcelize
data class Story(
    val createdAt: String,
    val description: String,
    val id: String,
    val lat: Double?,
    val lon: Double?,
    val name: String,
    val photoUrl: String
): Parcelable
