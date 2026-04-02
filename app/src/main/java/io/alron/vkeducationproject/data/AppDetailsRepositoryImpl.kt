package io.alron.vkeducationproject.data

import io.alron.vkeducationproject.data.source.local.AppDetailsDao
import io.alron.vkeducationproject.data.source.local.AppDetailsEntityMapper
import io.alron.vkeducationproject.data.source.remote.AppDetailsApi
import io.alron.vkeducationproject.domain.AppDetails
import io.alron.vkeducationproject.domain.AppDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AppDetailsRepositoryImpl @Inject constructor(
    private val apiMapper: AppDetailsMapper,
    private val appDetailsApi: AppDetailsApi,
    private val dao: AppDetailsDao,
    private val entityMapper: AppDetailsEntityMapper
) : AppDetailsRepository {
    override suspend fun get(id: String): AppDetails {
        val entity = dao.getAppDetails(id).first()
        return if (entity != null) {
            entityMapper.toDomain(entity)
        } else {
            val dto = appDetailsApi.get(id)
            val domain = apiMapper.toDomain(dto)
            val entityToSave = entityMapper.toEntity(domain)
            withContext(Dispatchers.IO) {
                dao.insertAppDetails(entityToSave)
            }
            domain
        }
    }
}