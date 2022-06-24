package id.buaja.maps.data.source

import id.buaja.maps.data.source.model.StoryResponse
import kotlinx.coroutines.flow.Flow

/**
 * Created by Julsapargi Nursam on 21/06/22
 * Mobile Engineer - Android
 */

interface RemoteDataSource {
    fun getLocationStory(): Flow<List<StoryResponse>>
}