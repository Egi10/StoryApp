package id.buaja.home.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import id.buaja.home.domain.usecase.GetStoryUseCase
import id.buaja.home.domain.usecase.GetStoryUseCaseImpl

/**
 * Created by Julsapargi Nursam on 5/22/22.
 * Mobile Engineer - Android
 */

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {
    @Binds
    @ViewModelScoped
    abstract fun bindsGetStoryUseCase(
        getStoryUseCaseImpl: GetStoryUseCaseImpl
    ): GetStoryUseCase
}