package io.alron.vkeducationproject.data

import io.alron.vkeducationproject.domain.AppDetails
import io.alron.vkeducationproject.domain.AppDetailsRepository

class AppDetailsRepositoryMockImpl(
    private val mapper: AppDetailsMapper,
    private val api: AppDetailsApi
) : AppDetailsRepository {
    override suspend fun get(id: String): AppDetails {
        val dto = api.get(id)
        val domain = mapper.toDomain(dto)
        return domain
    }
}