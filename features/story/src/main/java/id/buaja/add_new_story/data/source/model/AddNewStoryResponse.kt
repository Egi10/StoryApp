package id.buaja.add_new_story.data.source.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import id.buaja.add_new_story.domain.model.AddNewStory

@JsonClass(generateAdapter = true)
data class AddNewStoryResponse(
    @Json(name = "error")
    val error: Boolean,
    @Json(name = "message")
    val message: String
)

fun AddNewStoryResponse.mapTopAddStory(): AddNewStory {
    return AddNewStory(
        error = this.error,
        message = this.message
    )
}