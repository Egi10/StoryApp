package id.buaja.add_new_story.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.buaja.add_new_story.data.source.routes.StoryService
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by Julsapargi Nursam on 5/29/22.
 * Mobile Engineer - Android
 */

@Module
@InstallIn(SingletonComponent::class)
class ApiServiceModule {
    @Provides
    @Singleton
    fun providesService(retrofit: Retrofit): StoryService =
        retrofit.create(StoryService::class.java)
}