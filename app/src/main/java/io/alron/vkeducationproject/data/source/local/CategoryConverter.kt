package io.alron.vkeducationproject.data.source.local


import androidx.room.TypeConverter
import io.alron.vkeducationproject.domain.Category

class CategoryConverter {
    @TypeConverter
    fun fromCategory(category: Category): String = category.name

    @TypeConverter
    fun toCategory(categoryName: String): Category = Category.valueOf(categoryName)
}