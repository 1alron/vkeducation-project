package io.alron.vkeducationproject.data

import io.alron.vkeducationproject.domain.AppSummary
import javax.inject.Inject

class AppSummaryMapper @Inject constructor() {
    fun toDomain(dto: AppSummaryDto) = AppSummary(
        id = dto.id,
        name = dto.name,
        description = dto.description,
        category = dto.category,
        iconUrl = dto.iconUrl
    )
}