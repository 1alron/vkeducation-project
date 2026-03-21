package io.alron.vkeducationproject.data

import io.alron.vkeducationproject.domain.AppDetails
import io.alron.vkeducationproject.domain.AppDetailsRepository

class AppDetailsRepositoryImpl: AppDetailsRepository {
    override suspend fun get(id: String): AppDetails {
        TODO("Реализовать бекенд")
    }
}