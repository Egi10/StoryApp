package id.buaja.add_new_story.ui.add.model

import android.net.Uri
import id.buaja.add_new_story.domain.model.AddNewStory

/**
 * Created by Julsapargi Nursam on 5/29/22.
 * Mobile Engineer - Android
 */

data class AddNewStoryScreenUiState(
    val loading: Boolean = false,
    val description: String = "",
    val photo: Uri = Uri.EMPTY,

    val addNewStoryState: AddNewStoryUiState? = null
)

sealed interface AddNewStoryUiState {
    data class Success(val addNewStory: AddNewStory) : AddNewStoryUiState
    data class Error(val exception: String? = null) : AddNewStoryUiState
    object Loading : AddNewStoryUiState
}