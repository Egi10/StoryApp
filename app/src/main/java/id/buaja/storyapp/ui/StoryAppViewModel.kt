package id.buaja.storyapp.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import id.buaja.datastore.DataStoreManager
import javax.inject.Inject

/**
 * Created by Julsapargi Nursam on 5/21/22.
 * Mobile Engineer - Android
 */

@HiltViewModel
class StoryAppViewModel @Inject constructor(
    dataStoreManager: DataStoreManager,
) : ViewModel() {

    val tokenFlow = dataStoreManager.getToken()
}