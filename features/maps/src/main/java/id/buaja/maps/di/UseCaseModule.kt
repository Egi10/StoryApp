package id.buaja.maps.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import id.buaja.maps.domain.usecase.GetAllStoryLocationUseCase
import id.buaja.maps.domain.usecase.GetAllStoryLocationUseCaseImpl

/**
 * Created by Julsapargi Nursam on 22/06/22
 * Mobile Engineer - Android
 */

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {
    @Binds
    @ViewModelScoped
    abstract fun bindsGetAllStoryLocationUseCase(
        getAllStoryLocationUseCaseImpl: GetAllStoryLocationUseCaseImpl
    ): GetAllStoryLocationUseCase
}