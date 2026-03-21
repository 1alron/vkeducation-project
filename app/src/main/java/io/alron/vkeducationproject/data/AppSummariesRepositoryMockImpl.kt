package io.alron.vkeducationproject.data

import io.alron.vkeducationproject.data.source.local.AppSummariesApi
import io.alron.vkeducationproject.domain.AppSummariesRepository
import io.alron.vkeducationproject.domain.AppSummary

class AppSummariesRepositoryMockImpl(
    private val mapper: AppSummaryMapper,
    private val api: AppSummariesApi
) : AppSummariesRepository {
    override suspend fun get(): List<AppSummary> {
        val dtoList = api.get()
        val domainList = dtoList.map { mapper.toDomain(it) }
        return domainList
    }
}