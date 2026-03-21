package io.alron.vkeducationproject.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.alron.vkeducationproject.data.AppDetailsRepositoryMockImpl
import io.alron.vkeducationproject.data.AppSummariesRepositoryMockImpl
import io.alron.vkeducationproject.domain.AppDetailsRepository
import io.alron.vkeducationproject.domain.AppSummariesRepository

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {
    @Binds
    fun bindAppSummariesRepository(impl: AppSummariesRepositoryMockImpl): AppSummariesRepository

    @Binds
    fun bindAppDetailsRepository(impl: AppDetailsRepositoryMockImpl): AppDetailsRepository
}