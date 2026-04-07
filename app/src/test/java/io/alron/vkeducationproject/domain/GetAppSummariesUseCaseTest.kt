package io.alron.vkeducationproject.domain

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class GetAppSummariesUseCaseTest {

    private val repository: AppSummariesRepository = mockk()
    private val useCase = GetAppSummariesUseCase(repository)

    @Test
    fun `invoke calls repository get`() = runTest {
        coEvery { repository.get() } returns emptyList()
        useCase()
        coVerify(exactly = 1) { repository.get() }
    }

    @Test
    fun `invoke returns repository result`() = runTest {
        val expected = listOf(mockk<AppSummary>())
        coEvery { repository.get() } returns expected
        val result = useCase()
        assertEquals(expected, result)
    }

    @Test
    fun `invoke returns empty list when repository is empty`() = runTest {
        coEvery { repository.get() } returns emptyList()
        val result = useCase()
        assertEquals(0, result.size)
    }

    @Test(expected = Exception::class)
    fun `invoke throws exception when repository fails`() = runTest {
        coEvery { repository.get() } throws Exception("Error")
        useCase()
    }

    @Test
    fun `invoke returns multiple items`() = runTest {
        val expected = listOf(mockk<AppSummary>(), mockk<AppSummary>())
        coEvery { repository.get() } returns expected
        val result = useCase()
        assertEquals(2, result.size)
    }
}