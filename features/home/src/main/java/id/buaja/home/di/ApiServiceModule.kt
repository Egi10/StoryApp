package id.buaja.home.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.buaja.home.data.source.routes.HomeService
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by Julsapargi Nursam on 5/22/22.
 * Mobile Engineer - Android
 */

@Module
@InstallIn(SingletonComponent::class)
class ApiServiceModule {
    @Provides
    @Singleton
    fun providesHomeService(retrofit: Retrofit): HomeService =
        retrofit.create(HomeService::class.java)
}