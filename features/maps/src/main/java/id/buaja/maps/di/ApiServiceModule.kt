package id.buaja.maps.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.buaja.maps.data.source.routes.MapsService
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by Julsapargi Nursam on 22/06/22
 * Mobile Engineer - Android
 */

@Module
@InstallIn(SingletonComponent::class)
class ApiServiceModule {
    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit): MapsService =
        retrofit.create(MapsService::class.java)
}