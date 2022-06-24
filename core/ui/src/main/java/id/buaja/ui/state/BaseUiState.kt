package id.buaja.ui.state

/**
 * Created by Julsapargi Nursam on 22/06/22
 * Mobile Engineer - Android
 */

sealed interface BaseUiState<out T> {
    data class Success<T>(val data: T) : BaseUiState<T>
    data class Error(val exception: String? = null) : BaseUiState<Nothing>
    object Loading : BaseUiState<Nothing>
}