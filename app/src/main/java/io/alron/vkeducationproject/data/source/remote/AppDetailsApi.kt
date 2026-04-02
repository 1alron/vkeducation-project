package io.alron.vkeducationproject.data.source.remote

import io.alron.vkeducationproject.data.AppDetailsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface AppDetailsApi {
    @GET("catalog/{id}")
    suspend fun get(@Path("id") id: String): AppDetailsDto
}