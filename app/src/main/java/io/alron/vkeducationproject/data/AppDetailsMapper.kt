package io.alron.vkeducationproject.data

import io.alron.vkeducationproject.domain.AppDetails

class AppDetailsMapper(
    private val categoryMapper: CategoryMapper
) {
    fun toDomain(dto: AppDetailsDto) = AppDetails(
        id = dto.id,
        name = dto.name,
        developer = dto.developer,
        category = categoryMapper.toDomain(dto.category),
        ageRating = dto.ageRating,
        size = dto.size,
        iconUrl = dto.iconUrl,
        screenshotUrlList = dto.screenshotUrlList,
        description = dto.description
    )
}