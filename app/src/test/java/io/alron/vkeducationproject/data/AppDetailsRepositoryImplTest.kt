package io.alron.vkeducationproject.data

import io.alron.vkeducationproject.data.source.local.AppDetailsDao
import io.alron.vkeducationproject.data.source.local.AppDetailsEntity
import io.alron.vkeducationproject.data.source.local.AppDetailsEntityMapper
import io.alron.vkeducationproject.data.source.remote.AppDetailsApi
import io.alron.vkeducationproject.domain.AppDetails
import io.alron.vkeducationproject.domain.Category
import io.mockk.*
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class AppDetailsRepositoryImplTest {

    private val apiMapper: AppDetailsMapper = mockk()
    private val appDetailsApi: AppDetailsApi = mockk()
    private val dao: AppDetailsDao = mockk(relaxed = true)
    private val entityMapper: AppDetailsEntityMapper = mockk()

    private lateinit var repository: AppDetailsRepositoryImpl

    @Before
    fun setup() {
        repository = AppDetailsRepositoryImpl(apiMapper, appDetailsApi, dao, entityMapper)
    }

    @Test
    fun `get returns from dao if exists`() = runTest {
        val id = "1"
        val entity = mockk<AppDetailsEntity>()
        val domain = mockk<AppDetails>()
        every { dao.getAppDetails(id) } returns flowOf(entity)
        every { entityMapper.toDomain(entity) } returns domain

        val result = repository.get(id)

        assertEquals(domain, result)
        coVerify(exactly = 0) { appDetailsApi.get(any()) }
    }

    @Test
    fun `get fetches from api and saves to dao if not in local`() = runTest {
        val id = "1"
        val dto = mockk<AppDetailsDto>()
        val domain = mockk<AppDetails>()
        val entity = mockk<AppDetailsEntity>()

        every { dao.getAppDetails(id) } returns flowOf(null)
        coEvery { appDetailsApi.get(id) } returns dto
        every { apiMapper.toDomain(dto) } returns domain
        every { entityMapper.toEntity(domain) } returns entity

        val result = repository.get(id)

        assertEquals(domain, result)
        coVerify { appDetailsApi.get(id) }
        coVerify { dao.insertAppDetails(entity) }
    }

    @Test
    fun `toggleWishlist calls dao update with inverted status`() = runTest {
        val id = "1"
        val entity = mockk<AppDetailsEntity>()
        every { entity.isInWishlist } returns false
        every { dao.getAppDetails(id) } returns flowOf(entity)

        repository.toggleWishlist(id)

        coVerify { dao.updateWishlistStatus(id, true) }
    }

    @Test
    fun `toggleWishlist does nothing if app not found`() = runTest {
        val id = "1"
        every { dao.getAppDetails(id) } returns flowOf(null)

        repository.toggleWishlist(id)

        coVerify(exactly = 0) { dao.updateWishlistStatus(any(), any()) }
    }

    @Test
    fun `observeAppDetails returns domain flow`() = runTest {
        val id = "1"
        val entity = mockk<AppDetailsEntity>()
        val domain = mockk<AppDetails>()
        every { dao.getAppDetails(id) } returns flowOf(entity)
        every { entityMapper.toDomain(entity) } returns domain

        repository.observeAppDetails(id).collect {
            assertEquals(domain, it)
        }
    }
}