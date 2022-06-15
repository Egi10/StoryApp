package id.buaja.story.domain.repository

import androidx.paging.PagingData
import id.buaja.story.domain.model.AddNewStory
import id.buaja.common.result.Result
import id.buaja.story.domain.model.Story
import kotlinx.coroutines.flow.Flow
import java.io.File

/**
 * Created by Julsapargi Nursam on 5/28/22.
 * Mobile Engineer - Android
 */

interface StoryRepository {
    fun addNewStory(
        description: String,
        photo: File
    ): Flow<Result<AddNewStory>>

    fun getStory(): Flow<PagingData<Story>>
}