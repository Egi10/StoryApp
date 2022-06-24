package id.buaja.maps.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.buaja.maps.data.repository.MapsRepositoryImp
import id.buaja.maps.domain.repository.MapsRepository
import javax.inject.Singleton

/**
 * Created by Julsapargi Nursam on 22/06/22
 * Mobile Engineer - Android
 */

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindMapsRepository(mapsRepositoryImp: MapsRepositoryImp): MapsRepository
}