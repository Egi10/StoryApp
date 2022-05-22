package id.buaja.home.data.source

import androidx.paging.PagingSource
import id.buaja.home.data.source.model.StoryResponse

/**
 * Created by Julsapargi Nursam on 5/22/22.
 * Mobile Engineer - Android
 */

interface RemoteDataSource {
    fun getStories(): PagingSource<Int, StoryResponse>
}