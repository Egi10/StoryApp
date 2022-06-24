package id.buaja.story.data.source

import androidx.paging.PagingSource
import id.buaja.story.data.source.model.AddNewStoryResponse
import id.buaja.story.data.source.model.StoryResponse
import kotlinx.coroutines.flow.Flow
import java.io.File

/**
 * Created by Julsapargi Nursam on 5/28/22.
 * Mobile Engineer - Android
 */

interface RemoteDataSource {
    fun addNewStory(
        description: String,
        lat: Float,
        lon: Float,
        photo: File
    ): Flow<AddNewStoryResponse>

    fun getStories(): PagingSource<Int, StoryResponse>
}