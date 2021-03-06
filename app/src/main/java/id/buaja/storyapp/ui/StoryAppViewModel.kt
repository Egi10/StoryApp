package id.buaja.storyapp.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.buaja.datastore.DataStoreManager
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Julsapargi Nursam on 5/21/22.
 * Mobile Engineer - Android
 */

@HiltViewModel
class StoryAppViewModel @Inject constructor(
    dataStoreManager: DataStoreManager,
) : ViewModel() {

    var isLogin by mutableStateOf(false)

    init {
        viewModelScope.launch {
            dataStoreManager.getToken()
                .collect {
                    isLogin = it.isNotEmpty()
                }
        }
    }
}