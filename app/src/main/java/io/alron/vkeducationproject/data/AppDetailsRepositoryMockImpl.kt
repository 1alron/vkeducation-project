package io.alron.vkeducationproject.data

import io.alron.vkeducationproject.data.source.local.AppDetailsMockApi
import io.alron.vkeducationproject.domain.AppDetails
import io.alron.vkeducationproject.domain.AppDetailsRepository
import javax.inject.Inject

class AppDetailsRepositoryMockImpl @Inject constructor(
    private val mapper: AppDetailsMapper,
    private val api: AppDetailsMockApi
) : AppDetailsRepository {
    override suspend fun get(id: String): AppDetails {
        val dto = api.get(id)
        val domain = mapper.toDomain(dto)
        return domain
    }
}