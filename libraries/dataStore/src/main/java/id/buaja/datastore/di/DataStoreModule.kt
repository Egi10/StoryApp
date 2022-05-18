package id.buaja.datastore.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.buaja.datastore.DataStoreManager
import id.buaja.datastore.DataStoreManagerImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataStoreModule {
    @Binds
    @Singleton
    abstract fun provideDataStoreManager(dataStoreManagerImpl: DataStoreManagerImpl): DataStoreManager
}