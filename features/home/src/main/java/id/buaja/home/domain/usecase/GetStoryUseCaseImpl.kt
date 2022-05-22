package id.buaja.home.domain.usecase

import androidx.paging.PagingData
import id.buaja.home.domain.model.Story
import id.buaja.home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Julsapargi Nursam on 5/22/22.
 * Mobile Engineer - Android
 */

class GetStoryUseCaseImpl @Inject constructor(
    private val homeRepository: HomeRepository
): GetStoryUseCase {
    override fun invoke(): Flow<PagingData<Story>> {
        return homeRepository.getStory()
    }
}