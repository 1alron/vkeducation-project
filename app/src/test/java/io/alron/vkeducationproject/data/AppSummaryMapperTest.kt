package io.alron.vkeducationproject.data

import io.alron.vkeducationproject.domain.Category
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Test

class AppSummaryMapperTest {

    private val categoryMapper: CategoryMapper = mockk()
    private val mapper = AppSummaryMapper(categoryMapper)

    @Test
    fun `toDomain maps AppSummaryDto to AppSummary correctly`() {
        val dto = AppSummaryDto(
            id = "1",
            name = "Test App",
            description = "Description",
            category = "Игры",
            iconUrl = "url"
        )
        every { categoryMapper.toDomain("Игры") } returns Category.GAME

        val result = mapper.toDomain(dto)

        assertEquals(dto.id, result.id)
        assertEquals(dto.name, result.name)
        assertEquals(dto.description, result.description)
        assertEquals(Category.GAME, result.category)
        assertEquals(dto.iconUrl, result.iconUrl)
    }

    @Test
    fun `toDomain uses category mapper for APP`() {
        val dto = AppSummaryDto("1", "Name", "Desc", "Приложения", "icon")
        every { categoryMapper.toDomain("Приложения") } returns Category.APP
        val result = mapper.toDomain(dto)
        assertEquals(Category.APP, result.category)
    }

    @Test
    fun `toDomain uses category mapper for SOCIAL`() {
        val dto = AppSummaryDto("1", "Name", "Desc", "Социальные сети", "icon")
        every { categoryMapper.toDomain("Социальные сети") } returns Category.SOCIAL
        val result = mapper.toDomain(dto)
        assertEquals(Category.SOCIAL, result.category)
    }

    @Test
    fun `toDomain uses category mapper for PRODUCTIVITY`() {
        val dto = AppSummaryDto("1", "Name", "Desc", "Производительность", "icon")
        every { categoryMapper.toDomain("Производительность") } returns Category.PRODUCTIVITY
        val result = mapper.toDomain(dto)
        assertEquals(Category.PRODUCTIVITY, result.category)
    }

    @Test
    fun `toDomain handles empty description`() {
        val dto = AppSummaryDto("1", "Name", "", "Игры", "icon")
        every { categoryMapper.toDomain("Игры") } returns Category.GAME
        val result = mapper.toDomain(dto)
        assertEquals("", result.description)
    }
}