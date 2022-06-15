package id.buaja.story.domain.usecase.list

import androidx.paging.PagingData
import id.buaja.story.domain.model.Story
import id.buaja.story.domain.repository.StoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Julsapargi Nursam on 5/22/22.
 * Mobile Engineer - Android
 */

class GetStoryUseCaseImpl @Inject constructor(
    private val storyRepository: StoryRepository
): GetStoryUseCase {
    override fun invoke(): Flow<PagingData<Story>> {
        return storyRepository.getStory()
    }
}