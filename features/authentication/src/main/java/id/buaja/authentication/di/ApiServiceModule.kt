package id.buaja.authentication.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.buaja.authentication.data.source.routes.AuthenticationService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiServiceModule {
    @Provides
    @Singleton
    fun provideRegisterService(retrofit: Retrofit): AuthenticationService =
        retrofit.create(AuthenticationService::class.java)
}