package io.alron.vkeducationproject.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.alron.vkeducationproject.BuildConfig
import io.alron.vkeducationproject.data.AppDetailsMapper
import io.alron.vkeducationproject.data.CategoryMapper
import io.alron.vkeducationproject.data.source.remote.AppDetailsApi
import io.alron.vkeducationproject.data.source.remote.AppSummariesApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideAppSummariesApi(retrofit: Retrofit): AppSummariesApi =
        retrofit.create(AppSummariesApi::class.java)

    @Provides
    @Singleton
    fun provideAppDetailsApi(retrofit: Retrofit): AppDetailsApi =
        retrofit.create(AppDetailsApi::class.java)

    @Provides
    fun providesAppDetailsMapper(categoryMapper: CategoryMapper): AppDetailsMapper =
        AppDetailsMapper(categoryMapper)

    @Provides
    fun providesCategoryMapper(): CategoryMapper =
        CategoryMapper()
}