package io.alron.vkeducationproject.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.alron.vkeducationproject.BuildConfig
import io.alron.vkeducationproject.data.source.remote.AppSummariesApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideAppSummariesApi(retrofit: Retrofit): AppSummariesApi =
        retrofit.create(AppSummariesApi::class.java)
}