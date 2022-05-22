package id.buaja.home.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import id.buaja.home.data.source.RemoteDataSource
import id.buaja.home.data.source.model.asResultStory
import id.buaja.home.domain.model.Story
import id.buaja.home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Julsapargi Nursam on 5/22/22.
 * Mobile Engineer - Android
 */

class HomeRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
): HomeRepository {
    override fun getStory(): Flow<PagingData<Story>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = {
                remoteDataSource.getStories()
            }
        ).flow.asResultStory()
    }
}