package id.buaja.authentication.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import id.buaja.authentication.register.domain.usecase.RegisterUseCase
import id.buaja.authentication.register.domain.usecase.RegisterUseCaseImpl

/**
 * Created by Julsapargi Nursam on 5/20/22.
 * Mobile Engineer - Android
 */

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {
    @Binds
    @ViewModelScoped
    abstract fun bindsRegisterUseCase(
        registerUseCaseImpl: RegisterUseCaseImpl
    ): RegisterUseCase
}