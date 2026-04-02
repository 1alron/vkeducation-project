package io.alron.vkeducationproject.data

import io.alron.vkeducationproject.domain.AppDetails
import javax.inject.Inject

class AppDetailsMapper @Inject constructor(
    private val mapper: CategoryMapper
) {
    fun toDomain(dto: AppDetailsDto) = AppDetails(
        id = dto.id,
        name = dto.name,
        developer = dto.developer,
        category = mapper.toDomain(dto.category),
        ageRating = dto.ageRating,
        size = dto.size,
        iconUrl = dto.iconUrl,
        screenshotUrlList = dto.screenshotUrlList,
        description = dto.description
    )
}