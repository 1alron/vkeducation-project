package io.alron.vkeducationproject.data

import io.alron.vkeducationproject.domain.Category
import org.junit.Assert.assertEquals
import org.junit.Test

class CategoryMapperTest {

    private val mapper = CategoryMapper()

    @Test
    fun `toDomain maps 'Приложения' to Category APP`() {
        val result = mapper.toDomain("Приложения")
        assertEquals(Category.APP, result)
    }

    @Test
    fun `toDomain maps 'Игры' to Category GAME`() {
        val result = mapper.toDomain("Игры")
        assertEquals(Category.GAME, result)
    }

    @Test
    fun `toDomain maps 'Производительность' to Category PRODUCTIVITY`() {
        val result = mapper.toDomain("Производительность")
        assertEquals(Category.PRODUCTIVITY, result)
    }

    @Test
    fun `toDomain maps 'Социальные сети' to Category SOCIAL`() {
        val result = mapper.toDomain("Социальные сети")
        assertEquals(Category.SOCIAL, result)
    }

    @Test(expected = IllegalStateException::class)
    fun `toDomain throws IllegalStateException for unknown category`() {
        mapper.toDomain("Unknown")
    }
}