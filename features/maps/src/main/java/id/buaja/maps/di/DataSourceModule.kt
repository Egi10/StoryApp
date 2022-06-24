package id.buaja.maps.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.buaja.maps.data.source.RemoteDataSource
import id.buaja.maps.data.source.RemoteDataSourceImpl
import javax.inject.Singleton

/**
 * Created by Julsapargi Nursam on 22/06/22
 * Mobile Engineer - Android
 */

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource
}