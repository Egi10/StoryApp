package id.buaja.maps.data.source

import id.buaja.common.di.IoDispatcher
import id.buaja.maps.data.source.routes.MapsService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by Julsapargi Nursam on 21/06/22
 * Mobile Engineer - Android
 */

class RemoteDataSourceImpl @Inject constructor(
    private val mapsService: MapsService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
): RemoteDataSource {
    override fun getLocationStory() = flow {
        emit(
            mapsService.getLocationStories()
                .listStoryResponse
        )
    }.flowOn(ioDispatcher)
}