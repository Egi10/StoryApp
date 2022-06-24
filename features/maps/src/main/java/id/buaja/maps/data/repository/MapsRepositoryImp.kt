package id.buaja.maps.data.repository

import id.buaja.common.result.asResult
import id.buaja.maps.data.source.RemoteDataSource
import id.buaja.maps.data.source.model.mapToStoryMaps
import id.buaja.maps.domain.repository.MapsRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Created by Julsapargi Nursam on 22/06/22
 * Mobile Engineer - Android
 */

class MapsRepositoryImp @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : MapsRepository {
    override fun getAllLocationStory() = remoteDataSource.getLocationStory()
        .map {
            it.mapToStoryMaps()
        }.asResult()
}