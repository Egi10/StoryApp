package id.buaja.home.data.source.routes

import id.buaja.home.data.source.model.StoriesResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Julsapargi Nursam on 5/22/22.
 * Mobile Engineer - Android
 */

interface HomeService {
    @GET("stories")
    suspend fun getStories(
        @Query("page") page: Int,
        @Query("size") size: Int
    ): StoriesResponse
}