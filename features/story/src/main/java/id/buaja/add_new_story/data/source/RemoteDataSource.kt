package id.buaja.add_new_story.data.source

import id.buaja.add_new_story.data.source.model.AddNewStoryResponse
import kotlinx.coroutines.flow.Flow
import java.io.File

/**
 * Created by Julsapargi Nursam on 5/28/22.
 * Mobile Engineer - Android
 */

interface RemoteDataSource {
    fun addNewStory(
        description: String,
        photo: File
    ): Flow<AddNewStoryResponse>
}