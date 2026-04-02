package io.alron.vkeducationproject.domain

import kotlinx.coroutines.flow.Flow

interface AppDetailsRepository {
    suspend fun get(id: String): AppDetails

    suspend fun toggleWishlist(id: String)
    fun observeAppDetails(id: String): Flow<AppDetails>
}