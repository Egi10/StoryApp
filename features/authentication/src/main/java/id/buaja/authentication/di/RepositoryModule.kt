package id.buaja.authentication.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.buaja.authentication.data.repository.AuthenticationRepositoryImpl
import id.buaja.authentication.domain.repository.AuthenticationRepository
import javax.inject.Singleton

/**
 * Created by Julsapargi Nursam on 5/20/22.
 * Mobile Engineer - Android
 */

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindsRegisterRepository(
        registerRepositoryImpl: AuthenticationRepositoryImpl
    ): AuthenticationRepository
}