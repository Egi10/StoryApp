package id.buaja.maps.domain.usecase

import id.buaja.maps.domain.repository.MapsRepository
import javax.inject.Inject

/**
 * Created by Julsapargi Nursam on 22/06/22
 * Mobile Engineer - Android
 */

class GetAllStoryLocationUseCaseImpl @Inject constructor(
    private val mapsRepository: MapsRepository
): GetAllStoryLocationUseCase {
    override fun invoke() = mapsRepository.getAllLocationStory()
}