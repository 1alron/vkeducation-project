package io.alron.vkeducationproject.data

import io.alron.vkeducationproject.domain.Category
import javax.inject.Inject

class CategoryMapper @Inject constructor() {
    fun toDomain(category: String): Category = when (category) {
        "App" -> Category.APP
        "Game" -> Category.GAME
        else -> throw IllegalStateException("Unsupported category type: $category")
    }
}