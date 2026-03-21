package io.alron.vkeducationproject.data

import io.alron.vkeducationproject.data.source.remote.AppSummariesApi
import io.alron.vkeducationproject.domain.AppSummariesRepository
import io.alron.vkeducationproject.domain.AppSummary
import javax.inject.Inject

class AppSummariesRepositoryImpl @Inject constructor(
    private val api: AppSummariesApi,
    private val mapper: AppSummaryMapper
) : AppSummariesRepository{
    override suspend fun get(): List<AppSummary> {
        val summariesDto = api.get()
        val summaries = summariesDto.map { mapper.toDomain(it) }
        return summaries
    }
}