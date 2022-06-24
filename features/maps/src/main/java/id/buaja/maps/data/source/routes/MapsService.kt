package id.buaja.maps.data.source.routes

import id.buaja.maps.data.source.model.LocationStoryResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Julsapargi Nursam on 21/06/22
 * Mobile Engineer - Android
 */

interface MapsService {
    @GET("stories")
    suspend fun getLocationStories(
        @Query("location") location: Int = 1
    ): LocationStoryResponse
}