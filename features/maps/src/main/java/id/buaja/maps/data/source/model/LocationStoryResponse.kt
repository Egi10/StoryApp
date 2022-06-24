package id.buaja.maps.data.source.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LocationStoryResponse(
    @Json(name = "error")
    val error: Boolean,
    @Json(name = "listStory")
    val listStoryResponse: List<StoryResponse>,
    @Json(name = "message")
    val message: String
)