package io.alron.vkeducationproject.domain

import javax.inject.Inject

class GetAppSummariesUseCase @Inject constructor(
    private val repository: AppSummariesRepository
) {
    suspend operator fun invoke(): List<AppSummary> {
        return repository.get()
    }
}