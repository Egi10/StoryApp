package id.buaja.authentication.di

import dagger.Module
import dagger.Provides
import id.buaja.authentication.register.data.source.RemoteRegisterDataSource
import id.buaja.authentication.register.data.source.RemoteRegisterDataSourceImpl
import javax.inject.Singleton

@Module
@Singleton
abstract class RemoteDataSourceModule {
    @Provides
    @Singleton
    abstract fun provideRemoteRegisterDataSource(
        remoteRegisterDataSourceImpl: RemoteRegisterDataSourceImpl
    ): RemoteRegisterDataSource
}