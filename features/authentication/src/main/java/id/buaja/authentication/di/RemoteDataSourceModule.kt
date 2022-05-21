package id.buaja.authentication.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.buaja.authentication.register.data.source.RemoteRegisterDataSource
import id.buaja.authentication.register.data.source.RemoteRegisterDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {
    @Binds
    @Singleton
    abstract fun provideRemoteRegisterDataSource(
        remoteRegisterDataSourceImpl: RemoteRegisterDataSourceImpl
    ): RemoteRegisterDataSource
}