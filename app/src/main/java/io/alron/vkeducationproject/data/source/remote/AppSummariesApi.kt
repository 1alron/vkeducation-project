package io.alron.vkeducationproject.data.source.remote

import io.alron.vkeducationproject.data.AppSummaryDto
import kotlinx.coroutines.delay
import retrofit2.http.GET
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

interface AppSummariesApi {
    @GET("/catalog")
    suspend fun get(): List<AppSummaryDto>
}