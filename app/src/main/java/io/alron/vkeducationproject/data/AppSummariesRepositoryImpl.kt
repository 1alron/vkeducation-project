package io.alron.vkeducationproject.data

import io.alron.vkeducationproject.domain.AppSummariesRepository
import io.alron.vkeducationproject.domain.AppSummary

class AppSummariesRepositoryImpl : AppSummariesRepository{
    override suspend fun get(): List<AppSummary> {
        TODO("Реализовать бекенд")
    }
}