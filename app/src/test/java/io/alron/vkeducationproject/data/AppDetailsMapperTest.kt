package io.alron.vkeducationproject.data

import io.alron.vkeducationproject.domain.Category
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Test

class AppDetailsMapperTest {

    private val categoryMapper: CategoryMapper = mockk()
    private val mapper = AppDetailsMapper(categoryMapper)

    @Test
    fun `toDomain maps AppDetailsDto to AppDetails correctly`() {
        val dto = AppDetailsDto(
            id = "1",
            name = "Test App",
            developer = "Dev",
            category = "Игры",
            ageRating = 12,
            size = 100f,
            iconUrl = "icon",
            screenshotUrlList = listOf("s1", "s2"),
            description = "Desc"
        )
        every { categoryMapper.toDomain("Игры") } returns Category.GAME

        val result = mapper.toDomain(dto)

        assertEquals(dto.id, result.id)
        assertEquals(dto.name, result.name)
        assertEquals(dto.developer, result.developer)
        assertEquals(Category.GAME, result.category)
        assertEquals(dto.ageRating, result.ageRating)
        assertEquals(dto.size, result.size)
        assertEquals(dto.iconUrl, result.iconUrl)
        assertEquals(dto.screenshotUrlList, result.screenshotUrlList)
        assertEquals(dto.description, result.description)
    }

    @Test
    fun `toDomain uses category mapper for APP`() {
        val dto = createDto(category = "Приложения")
        every { categoryMapper.toDomain("Приложения") } returns Category.APP
        val result = mapper.toDomain(dto)
        assertEquals(Category.APP, result.category)
    }

    @Test
    fun `toDomain uses category mapper for SOCIAL`() {
        val dto = createDto(category = "Социальные сети")
        every { categoryMapper.toDomain("Социальные сети") } returns Category.SOCIAL
        val result = mapper.toDomain(dto)
        assertEquals(Category.SOCIAL, result.category)
    }

    @Test
    fun `toDomain handles empty screenshot list`() {
        val dto = createDto(screenshots = emptyList())
        every { categoryMapper.toDomain(any()) } returns Category.GAME
        val result = mapper.toDomain(dto)
        assertEquals(emptyList<String>(), result.screenshotUrlList)
    }

    @Test
    fun `toDomain maps age rating correctly`() {
        val dto = createDto(ageRating = 18)
        every { categoryMapper.toDomain(any()) } returns Category.GAME
        val result = mapper.toDomain(dto)
        assertEquals(18, result.ageRating)
    }

    private fun createDto(
        category: String = "Игры",
        screenshots: List<String> = listOf("s1"),
        ageRating: Int = 12
    ) = AppDetailsDto(
        id = "1",
        name = "Name",
        developer = "Dev",
        category = category,
        ageRating = ageRating,
        size = 10f,
        iconUrl = "icon",
        screenshotUrlList = screenshots,
        description = "Desc"
    )
}