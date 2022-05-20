package id.buaja.authentication.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.buaja.authentication.register.data.source.routes.RegisterService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiServiceModule {
    @Provides
    @Singleton
    fun provideRegisterService(retrofit: Retrofit): RegisterService =
        retrofit.create(RegisterService::class.java)
}