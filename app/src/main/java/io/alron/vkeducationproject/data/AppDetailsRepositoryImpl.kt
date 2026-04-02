package io.alron.vkeducationproject.data

import io.alron.vkeducationproject.data.source.remote.AppDetailsApi
import io.alron.vkeducationproject.domain.AppDetails
import io.alron.vkeducationproject.domain.AppDetailsRepository
import javax.inject.Inject

class AppDetailsRepositoryImpl @Inject constructor(
    private val mapper: AppDetailsMapper,
    private val appDetailsApi: AppDetailsApi
): AppDetailsRepository {
    override suspend fun get(id: String): AppDetails {
        val appDetailsDto = appDetailsApi.get(id)
        return mapper.toDomain(appDetailsDto)
    }
}