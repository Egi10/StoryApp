package id.buaja.story.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import id.buaja.story.data.source.RemoteDataSource
import id.buaja.story.data.source.model.mapTopAddStory
import id.buaja.story.domain.model.AddNewStory
import id.buaja.story.domain.repository.StoryRepository
import id.buaja.common.result.Result
import id.buaja.common.result.asResult
import id.buaja.story.data.source.model.asResultStory
import id.buaja.story.domain.model.Story
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

    override fun getStory(): Flow<PagingData<Story>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = {
                remoteDataSource.getStories()
            }
        ).flow.asResultStory()
    }
}