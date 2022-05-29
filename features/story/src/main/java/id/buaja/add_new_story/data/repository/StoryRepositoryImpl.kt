package id.buaja.add_new_story.data.repository

import id.buaja.add_new_story.data.source.RemoteDataSource
import id.buaja.add_new_story.data.source.model.mapTopAddStory
import id.buaja.add_new_story.domain.model.AddNewStory
import id.buaja.add_new_story.domain.repository.StoryRepository
import id.buaja.common.result.Result
import id.buaja.common.result.asResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.io.File
import javax.inject.Inject

/**
 * Created by Julsapargi Nursam on 5/28/22.
 * Mobile Engineer - Android
 */

class StoryRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : StoryRepository {

    override fun addNewStory(description: String, photo: File): Flow<Result<AddNewStory>> {
        return remoteDataSource.addNewStory(
            description = description,
            photo = photo
        ).map {
            it.mapTopAddStory()
        }.asResult()
    }

}