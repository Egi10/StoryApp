package id.buaja.story.domain.usecase.add

import android.content.Context
import android.net.Uri
import dagger.hilt.android.qualifiers.ApplicationContext
import id.buaja.story.domain.model.AddNewStory
import id.buaja.story.domain.repository.StoryRepository
import id.buaja.story.utils.uriToFile
import id.buaja.common.result.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Julsapargi Nursam on 5/28/22.
 * Mobile Engineer - Android
 */

class AddNewStoryUseCaseImpl @Inject constructor(
    private val storyRepository: StoryRepository,
    @ApplicationContext private val context: Context
) : AddNewStoryUseCase {
    override fun invoke(
        description: String,
        lat: Float,
        lon: Float,
        photo: Uri
    ): Flow<Result<AddNewStory>> {
        val file = uriToFile(
            selectedImg = photo,
            context = context
        )

        return storyRepository.addNewStory(
            description = description,
            lat = lat,
            lon = lon,
            photo = file
        )
    }
}