package id.buaja.home.domain.model

/**
 * Created by Julsapargi Nursam on 5/22/22.
 * Mobile Engineer - Android
 */

data class Story(
    val createdAt: String,
    val description: String,
    val id: String,
    val lat: Double?,
    val lon: Double?,
    val name: String,
    val photoUrl: String
)
