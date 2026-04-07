package io.alron.vkeducationproject.domain

import app.cash.turbine.test
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class ObserveAppDetailsUseCaseTest {

    private val repository: AppDetailsRepository = mockk()
    private val useCase = ObserveAppDetailsUseCase(repository)

    @Test
    fun `invoke calls repository observeAppDetails`() = runTest {
        val id = "1"
        every { repository.observeAppDetails(id) } returns flowOf(mockk())
        useCase(id)
        verify(exactly = 1) { repository.observeAppDetails(id) }
    }

    @Test
    fun `invoke returns flow from repository`() = runTest {
        val id = "1"
        val expected = mockk<AppDetails>()
        every { repository.observeAppDetails(id) } returns flowOf(expected)
        
        useCase(id).test {
            assertEquals(expected, awaitItem())
            awaitComplete()
        }
    }

    @Test
    fun `invoke handles multiple emissions`() = runTest {
        val id = "1"
        val details1 = mockk<AppDetails>()
        val details2 = mockk<AppDetails>()
        every { repository.observeAppDetails(id) } returns flowOf(details1, details2)

        useCase(id).test {
            assertEquals(details1, awaitItem())
            assertEquals(details2, awaitItem())
            awaitComplete()
        }
    }

    @Test
    fun `invoke works for different ids`() = runTest {
        every { repository.observeAppDetails(any()) } returns flowOf(mockk())

        useCase("1")
        useCase("2")

        verify { repository.observeAppDetails("1") }
        verify { repository.observeAppDetails("2") }
    }

    @Test
    fun `invoke returns empty flow if repository returns empty`() = runTest {
        val id = "1"
        every { repository.observeAppDetails(id) } returns emptyFlow()
        
        useCase(id).test {
            awaitComplete()
        }
    }
}