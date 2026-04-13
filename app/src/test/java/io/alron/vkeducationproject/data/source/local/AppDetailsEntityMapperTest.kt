package io.alron.vkeducationproject.data.source.local

import io.alron.vkeducationproject.domain.AppDetails
import io.alron.vkeducationproject.domain.Category
import org.junit.Assert.assertEquals
import org.junit.Test

class AppDetailsEntityMapperTest {

    private val mapper = AppDetailsEntityMapper()

    @Test
    fun `toEntity maps domain to entity correctly`() {
        val domain = AppDetails(
            id = "1",
            name = "Name",
            developer = "Dev",
            category = Category.GAME,
            ageRating = 12,
            size = 100f,
            iconUrl = "icon",
            screenshotUrlList = listOf("s1"),
            description = "Desc",
            isInWishlist = true
        )

        val result = mapper.toEntity(domain)

        assertEquals(domain.id, result.id)
        assertEquals(domain.name, result.name)
        assertEquals(domain.developer, result.developer)
        assertEquals(domain.category, result.category)
        assertEquals(domain.ageRating, result.ageRating)
        assertEquals(domain.size, result.size)
        assertEquals(domain.iconUrl, result.iconUrl)
        assertEquals(domain.description, result.description)
        assertEquals(domain.isInWishlist, result.isInWishlist)
    }

    @Test
    fun `toDomain maps entity to domain correctly`() {
        val entity = AppDetailsEntity(
            id = "1",
            name = "Name",
            developer = "Dev",
            category = Category.GAME,
            ageRating = 12,
            size = 100f,
            iconUrl = "icon",
            screenshots = null,
            description = "Desc",
            isInWishlist = true
        )

        val result = mapper.toDomain(entity)

        assertEquals(entity.id, result.id)
        assertEquals(entity.name, result.name)
        assertEquals(entity.developer, result.developer)
        assertEquals(entity.category, result.category)
        assertEquals(entity.ageRating, result.ageRating)
        assertEquals(entity.size, result.size)
        assertEquals(entity.iconUrl, result.iconUrl)
        assertEquals(entity.description, result.description)
        assertEquals(entity.isInWishlist, result.isInWishlist)
    }

    @Test
    fun `toEntity maps wishlist status false`() {
        val domain = createDomain(isInWishlist = false)
        val result = mapper.toEntity(domain)
        assertEquals(false, result.isInWishlist)
    }

    @Test
    fun `toEntity maps wishlist status true`() {
        val domain = createDomain(isInWishlist = true)
        val result = mapper.toEntity(domain)
        assertEquals(true, result.isInWishlist)
    }

    @Test
    fun `toDomain maps wishlist status false`() {
        val entity = createEntity(isInWishlist = false)
        val result = mapper.toDomain(entity)
        assertEquals(false, result.isInWishlist)
    }

    @Test
    fun `toDomain maps wishlist status true`() {
        val entity = createEntity(isInWishlist = true)
        val result = mapper.toDomain(entity)
        assertEquals(true, result.isInWishlist)
    }

    private fun createDomain(isInWishlist: Boolean) = AppDetails(
        "1",
        "N",
        "D",
        Category.APP,
        0,
        0f,
        "i",
        null,
        "d",
        isInWishlist
    )

    private fun createEntity(isInWishlist: Boolean) = AppDetailsEntity(
        id = "1",
        name = "N",
        developer = "D",
        category = Category.APP,
        ageRating = 0,
        size = 0f,
        iconUrl = "i",
        screenshots = null,
        description = "d",
        isInWishlist = isInWishlist
    )
}