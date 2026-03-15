package io.alron.vkeducationproject.domain

interface AppSummariesRepository {
    suspend fun get(): List<AppSummary>
}