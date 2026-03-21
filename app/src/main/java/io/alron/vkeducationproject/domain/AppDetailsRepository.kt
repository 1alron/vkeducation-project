package io.alron.vkeducationproject.domain

interface AppDetailsRepository {
    suspend fun get(id: String): AppDetails
}