package id.buaja.story.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.buaja.story.data.repository.StoryRepositoryImpl
import id.buaja.story.domain.repository.StoryRepository
import javax.inject.Singleton

/**
 * Created by Julsapargi Nursam on 5/29/22.
 * Mobile Engineer - Android
 */

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindsStoryRepository(
        storyRepositoryImpl: StoryRepositoryImpl
    ): StoryRepository
}