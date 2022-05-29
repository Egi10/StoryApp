package id.buaja.add_new_story.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.buaja.add_new_story.data.source.RemoteDataSource
import id.buaja.add_new_story.data.source.RemoteDataSourceImpl
import javax.inject.Singleton

/**
 * Created by Julsapargi Nursam on 5/29/22.
 * Mobile Engineer - Android
 */

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindRemoteDataSource(
        remoteDataSourceImpl: RemoteDataSourceImpl
    ): RemoteDataSource
}