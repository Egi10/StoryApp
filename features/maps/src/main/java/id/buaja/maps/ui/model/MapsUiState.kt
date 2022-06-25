package id.buaja.maps.ui.model

import id.buaja.maps.domain.model.StoryMaps

/**
 * Created by Julsapargi Nursam on 22/06/22
 * Mobile Engineer - Android
 */

data class MapsUiState(
    val loading: Boolean = false,
    val isEmpty: Boolean = false,
    val data: List<StoryMaps> = emptyList(),
    val error: String = "",
    val locationNow: Boolean = false
)
