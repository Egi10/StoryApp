package id.buaja.add_new_story.ui.add.model

import android.net.Uri

/**
 * Created by Julsapargi Nursam on 5/29/22.
 * Mobile Engineer - Android
 */

sealed class AddNewStoryEventState {
    data class DescriptionsChanged(val description: String): AddNewStoryEventState()
    data class PhotoChanged(val uri: Uri): AddNewStoryEventState()

    object Upload : AddNewStoryEventState()
}
