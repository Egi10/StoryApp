package id.buaja.maps.domain.usecase

import id.buaja.common.result.Result
import id.buaja.maps.domain.model.StoryMaps
import kotlinx.coroutines.flow.Flow

/**
 * Created by Julsapargi Nursam on 22/06/22
 * Mobile Engineer - Android
 */

interface GetAllStoryLocationUseCase {
    operator fun invoke(): Flow<Result<List<StoryMaps>>>
}