package id.buaja.home.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.buaja.home.data.source.RemoteDataSource
import id.buaja.home.data.source.RemoteDataSourceImpl
import javax.inject.Singleton

/**
 * Created by Julsapargi Nursam on 5/22/22.
 * Mobile Engineer - Android
 */

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindsRemoteDataSource(
        remoteDataSourceImpl: RemoteDataSourceImpl
    ): RemoteDataSource
}