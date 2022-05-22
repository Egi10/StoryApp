package id.buaja.home.data.source.model


import androidx.paging.PagingData
import androidx.paging.map
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import id.buaja.home.domain.model.Story
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@JsonClass(generateAdapter = true)
data class StoriesResponse(
    @Json(name = "error")
    val error: Boolean,
    @Json(name = "listStory")
    val listStory: List<StoryResponse>,
    @Json(name = "message")
    val message: String
)

@JsonClass(generateAdapter = true)
data class StoryResponse(
    @Json(name = "createdAt")
    val createdAt: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "id")
    val id: String,
    @Json(name = "lat")
    val lat: Double?,
    @Json(name = "lon")
    val lon: Double?,
    @Json(name = "name")
    val name: String,
    @Json(name = "photoUrl")
    val photoUrl: String
)

fun Flow<PagingData<StoryResponse>>.asResultStory(): Flow<PagingData<Story>> {
    return this.map { paging ->
        paging.map {
            Story(
                createdAt = it.createdAt,
                description = it.description,
                id = it.id,
                lat = it.lat,
                lon = it.lon,
                name = it.name,
                photoUrl = it.photoUrl
            )
        }
    }
}