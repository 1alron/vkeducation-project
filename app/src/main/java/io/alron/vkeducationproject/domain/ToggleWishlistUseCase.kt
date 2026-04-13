package io.alron.vkeducationproject.domain

import javax.inject.Inject

class ToggleWishlistUseCase @Inject constructor(
    private val repository: AppDetailsRepository
) {
    suspend operator fun invoke(id: String) {
        repository.toggleWishlist(id)
    }
}