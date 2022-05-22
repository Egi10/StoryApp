package id.buaja.home.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.buaja.home.data.repository.HomeRepositoryImpl
import id.buaja.home.domain.repository.HomeRepository
import javax.inject.Singleton

/**
 * Created by Julsapargi Nursam on 5/22/22.
 * Mobile Engineer - Android
 */

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindsHomeRepository(
        homeRepositoryImpl: HomeRepositoryImpl
    ): HomeRepository
}