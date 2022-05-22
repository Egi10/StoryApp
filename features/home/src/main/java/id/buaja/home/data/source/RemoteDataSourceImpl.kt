package id.buaja.home.data.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import id.buaja.home.data.source.model.StoryResponse
import id.buaja.home.data.source.routes.HomeService
import retrofit2.HttpException
import javax.inject.Inject

/**
 * Created by Julsapargi Nursam on 5/22/22.
 * Mobile Engineer - Android
 */

class RemoteDataSourceImpl @Inject constructor(
    private val homeService: HomeService
) : RemoteDataSource {
    override fun getStories(): PagingSource<Int, StoryResponse> {
        return object : PagingSource<Int, StoryResponse>() {
            override fun getRefreshKey(state: PagingState<Int, StoryResponse>): Int? {
                return state.anchorPosition?.let { anchorPosition ->
                    val anchorPage = state.closestPageToPosition(anchorPosition)
                    anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
                }
            }

            override suspend fun load(params: LoadParams<Int>): LoadResult<Int, StoryResponse> {
                return try {
                    val position = params.key ?: 1
                    val response = homeService.getStories(
                        page = position,
                        size = 20
                    )
                    val prevKey = if (position > 0) {
                        position - 1
                    } else {
                        null
                    }

                    val nextKey = if (response.listStory.isNotEmpty()) {
                        position + 1
                    } else {
                        null
                    }

                    LoadResult.Page(
                        data = response.listStory,
                        prevKey = prevKey,
                        nextKey = nextKey
                    )
                } catch (e: Exception) {
                    return LoadResult.Error(e)
                } catch (e: HttpException) {
                    return LoadResult.Error(e)
                }
            }

        }
    }
}