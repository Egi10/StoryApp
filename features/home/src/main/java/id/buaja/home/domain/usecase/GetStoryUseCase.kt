package id.buaja.home.domain.usecase

import androidx.paging.PagingData
import id.buaja.home.domain.model.Story
import kotlinx.coroutines.flow.Flow

/**
 * Created by Julsapargi Nursam on 5/22/22.
 * Mobile Engineer - Android
 */

interface GetStoryUseCase {
    operator fun invoke(): Flow<PagingData<Story>>
}