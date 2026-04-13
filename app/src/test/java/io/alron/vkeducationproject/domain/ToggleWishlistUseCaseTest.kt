package io.alron.vkeducationproject.domain

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test

class ToggleWishlistUseCaseTest {

    private val repository: AppDetailsRepository = mockk()
    private val useCase = ToggleWishlistUseCase(repository)

    @Test
    fun `invoke calls repository toggleWishlist`() = runTest {
        val id = "1"
        coEvery { repository.toggleWishlist(id) } returns Unit
        useCase(id)
        coVerify(exactly = 1) { repository.toggleWishlist(id) }
    }

    @Test
    fun `invoke works with different ids`() = runTest {
        coEvery { repository.toggleWishlist(any()) } returns Unit
        useCase("1")
        useCase("2")
        coVerify { repository.toggleWishlist("1") }
        coVerify { repository.toggleWishlist("2") }
    }

    @Test(expected = Exception::class)
    fun `invoke throws exception when repository fails`() = runTest {
        coEvery { repository.toggleWishlist(any()) } throws Exception("DB Error")
        useCase("1")
    }

    @Test
    fun `invoke handles empty id`() = runTest {
        coEvery { repository.toggleWishlist("") } returns Unit
        useCase("")
        coVerify { repository.toggleWishlist("") }
    }

    @Test
    fun `invoke called exactly once`() = runTest {
        coEvery { repository.toggleWishlist(any()) } returns Unit
        useCase("1")
        coVerify(exactly = 1) { repository.toggleWishlist("1") }
    }
}