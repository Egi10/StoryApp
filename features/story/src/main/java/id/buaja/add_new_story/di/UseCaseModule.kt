package id.buaja.add_new_story.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import id.buaja.add_new_story.domain.usecase.add.AddNewStoryUseCase
import id.buaja.add_new_story.domain.usecase.add.AddNewStoryUseCaseImpl

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
}