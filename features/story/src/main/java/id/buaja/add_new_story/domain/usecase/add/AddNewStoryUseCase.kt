package id.buaja.add_new_story.domain.usecase.add

import android.net.Uri
import id.buaja.add_new_story.domain.model.AddNewStory
import id.buaja.common.result.Result
import kotlinx.coroutines.flow.Flow
import java.io.File

/**
 * Created by Julsapargi Nursam on 5/28/22.
 * Mobile Engineer - Android
 */

interface AddNewStoryUseCase {
    operator fun invoke(
        description: String,
        photo: Uri
    ): Flow<Result<AddNewStory>>
}