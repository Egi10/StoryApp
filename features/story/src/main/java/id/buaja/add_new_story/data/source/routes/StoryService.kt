package id.buaja.add_new_story.data.source.routes

import id.buaja.add_new_story.data.source.model.AddNewStoryResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

/**
 * Created by Julsapargi Nursam on 5/28/22.
 * Mobile Engineer - Android
 */

interface StoryService {
    @Multipart
    @POST("stories")
    suspend fun addNewStory(
        @Part("description") description: RequestBody,
        @Part photo: MultipartBody.Part
    ): AddNewStoryResponse
}