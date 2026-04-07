package io.alron.vkeducationproject.data

import io.alron.vkeducationproject.data.source.remote.AppSummariesApi
import io.alron.vkeducationproject.domain.AppSummary
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class AppSummariesRepositoryImplTest {

    private val api: AppSummariesApi = mockk()
    private val mapper: AppSummaryMapper = mockk()
    private lateinit var repository: AppSummariesRepositoryImpl

    @Before
    fun setup() {
        repository = AppSummariesRepositoryImpl(api, mapper)
    }

    @Test
    fun `get returns mapped summaries from api`() = runTest {
        val dto1 = mockk<AppSummaryDto>()
        val dto2 = mockk<AppSummaryDto>()
        val domain1 = mockk<AppSummary>()
        val domain2 = mockk<AppSummary>()

        coEvery { api.get() } returns listOf(dto1, dto2)
        every { mapper.toDomain(dto1) } returns domain1
        every { mapper.toDomain(dto2) } returns domain2

        val result = repository.get()

        assertEquals(2, result.size)
        assertEquals(domain1, result[0])
        assertEquals(domain2, result[1])
    }

    @Test
    fun `get returns empty list when api returns empty`() = runTest {
        coEvery { api.get() } returns emptyList()
        val result = repository.get()
        assertEquals(0, result.size)
    }

    @Test(expected = Exception::class)
    fun `get throws exception when api fails`() = runTest {
        coEvery { api.get() } throws Exception("Network error")
        repository.get()
    }

    @Test
    fun `get maps all items from api`() = runTest {
        val dtos = List(5) { mockk<AppSummaryDto>() }
        coEvery { api.get() } returns dtos
        every { mapper.toDomain(any()) } returns mockk()

        val result = repository.get()

        assertEquals(5, result.size)
    }

    @Test
    fun `get maintains order from api`() = runTest {
        val dto1 = mockk<AppSummaryDto>()
        val dto2 = mockk<AppSummaryDto>()
        val domain1 = mockk<AppSummary>()
        val domain2 = mockk<AppSummary>()

        coEvery { api.get() } returns listOf(dto1, dto2)
        every { mapper.toDomain(dto1) } returns domain1
        every { mapper.toDomain(dto2) } returns domain2

        val result = repository.get()

        assertEquals(domain1, result[0])
        assertEquals(domain2, result[1])
    }
}