package id.buaja.maps.data.source.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import id.buaja.maps.domain.model.StoryMaps

@JsonClass(generateAdapter = true)
data class StoryResponse(
    @Json(name = "createdAt")
    val createdAt: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "id")
    val id: String,
    @Json(name = "lat")
    val lat: Double,
    @Json(name = "lon")
    val lon: Double,
    @Json(name = "name")
    val name: String,
    @Json(name = "photoUrl")
    val photoUrl: String
)

fun List<StoryResponse>.mapToStoryMaps(): List<StoryMaps> {
    val list: MutableList<StoryMaps> = mutableListOf()

    this.map {
        list.add(
            StoryMaps(
                lat = it.lat,
                lon = it.lon,
                name = it.name
            )
        )
    }

    return list
}