package com.example.worldpopulation.di

import com.example.worldpopulation.data.repository.PopulationRepositoryImpl
import com.example.worldpopulation.domain.repository.PopulationRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindPopulationRepository(impl: PopulationRepositoryImpl): PopulationRepository
}

@Module
@InstallIn(SingletonComponent::class)
object DispatcherModule {

    @Provides
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO
}
