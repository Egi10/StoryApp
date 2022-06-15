package id.buaja.story.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import id.buaja.story.domain.usecase.add.AddNewStoryUseCase
import id.buaja.story.domain.usecase.add.AddNewStoryUseCaseImpl
import id.buaja.story.domain.usecase.list.GetStoryUseCase
import id.buaja.story.domain.usecase.list.GetStoryUseCaseImpl

/**
 * Created by Julsapargi Nursam on 5/29/22.
 * Mobile Engineer - Android
 */

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {
    @Binds
    @ViewModelScoped
    abstract fun bindAddNewStoryUseCase(
        addNewStoryUseCaseImpl: AddNewStoryUseCaseImpl
    ): AddNewStoryUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindsGetStoryUseCase(
        getStoryUseCaseImpl: GetStoryUseCaseImpl
    ): GetStoryUseCase
}