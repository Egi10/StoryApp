package id.buaja.home.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import id.buaja.datastore.DataStoreManager
import id.buaja.home.domain.model.Story
import id.buaja.home.domain.usecase.GetStoryUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Julsapargi Nursam on 5/22/22.
 * Mobile Engineer - Android
 */

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dataStoreManager: DataStoreManager,
    private val getStoryUseCase: GetStoryUseCase
) : ViewModel() {

    fun clearToken() {
        viewModelScope.launch {
            dataStoreManager.deleteToken()
        }
    }

    fun getStory(): Flow<PagingData<Story>> {
        return getStoryUseCase.invoke()
            .cachedIn(viewModelScope)
    }
}