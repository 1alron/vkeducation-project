package io.alron.vkeducationproject.data

import io.alron.vkeducationproject.domain.AppSummary
import javax.inject.Inject

class AppSummaryMapper @Inject constructor(
    private val mapper: CategoryMapper
) {
    fun toDomain(dto: AppSummaryDto) = AppSummary(
        id = dto.id,
        name = dto.name,
        description = dto.description,
        category = mapper.toDomain(dto.category),
        iconUrl = dto.iconUrl
    )
}