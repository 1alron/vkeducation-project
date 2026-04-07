package io.alron.vkeducationproject.domain

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class GetAppDetailsUseCaseTest {

    private val repository: AppDetailsRepository = mockk()
    private val useCase = GetAppDetailsUseCase(repository)

    @Test
    fun `invoke calls repository get with id`() = runTest {
        val id = "123"
        coEvery { repository.get(id) } returns mockk()
        useCase(id)
        coVerify(exactly = 1) { repository.get(id) }
    }

    @Test
    fun `invoke returns repository result`() = runTest {
        val id = "1"
        val expected = mockk<AppDetails>()
        coEvery { repository.get(id) } returns expected
        val result = useCase(id)
        assertEquals(expected, result)
    }

    @Test(expected = Exception::class)
    fun `invoke throws exception when repository fails`() = runTest {
        val id = "1"
        coEvery { repository.get(id) } throws Exception("Not found")
        useCase(id)
    }

    @Test
    fun `invoke works with different ids`() = runTest {
        val id1 = "1"
        val id2 = "2"
        coEvery { repository.get(any()) } returns mockk()
        
        useCase(id1)
        useCase(id2)
        
        coVerify { repository.get(id1) }
        coVerify { repository.get(id2) }
    }

    @Test
    fun `invoke handles null-like values if allowed by domain`() = runTest {
        val id = ""
        coEvery { repository.get(id) } returns mockk()
        useCase(id)
        coVerify { repository.get(id) }
    }
}