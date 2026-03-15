package io.alron.vkeducationproject.data

import io.alron.vkeducationproject.domain.Category

class CategoryMapper {
    fun toDomain(category: String): Category = when (category) {
        "App" -> Category.APP
        "Game" -> Category.GAME
        else -> throw IllegalStateException("Unsupported category type: $category")
    }
}