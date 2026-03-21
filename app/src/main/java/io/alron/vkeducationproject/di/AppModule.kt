package io.alron.vkeducationproject.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.alron.vkeducationproject.data.AppDetailsRepositoryImpl
import io.alron.vkeducationproject.data.AppDetailsRepositoryMockImpl
import io.alron.vkeducationproject.data.AppSummariesRepositoryImpl
import io.alron.vkeducationproject.domain.AppDetailsRepository
import io.alron.vkeducationproject.domain.AppSummariesRepository

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {
    @Binds
    fun bindAppSummariesRepository(impl: AppSummariesRepositoryImpl): AppSummariesRepository

    @Binds
    fun bindAppDetailsRepository(impl: AppDetailsRepositoryMockImpl): AppDetailsRepository
}