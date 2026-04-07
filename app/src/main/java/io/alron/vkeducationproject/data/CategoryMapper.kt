package io.alron.vkeducationproject.data

import io.alron.vkeducationproject.domain.Category
import javax.inject.Inject

class CategoryMapper @Inject constructor() {
    fun toDomain(category: String): Category = when (category) {
        "Приложения" -> Category.APP
        "Игры" -> Category.GAME
        "Производительность" -> Category.PRODUCTIVITY
        "Социальные сети" -> Category.SOCIAL
        "Образование" -> Category.EDUCATION
        "Развлечения" -> Category.ENTERTAINMENT
        "Музыка" -> Category.MUSIC
        "Видео" -> Category.VIDEO
        "Фотография" -> Category.PHOTOGRAPHY
        "Здоровье" -> Category.HEALTH
        "Здоровье и фитнес" -> Category.HEALTH_AND_FITNESS
        "Фото и видео" -> Category.PHOTO_AND_VIDEO
        "Еда и напитки" -> Category.FOOD_AND_DRINKS
        "Образ жизни" -> Category.LIFESTYLE
        "Навигация" -> Category.NAVIGATION
        "Общение" -> Category.CHATTING
        "Погода" -> Category.WEATHER
        "Книги и справочники" -> Category.BOOKS_AND_REFERENCES
        "Спорт" -> Category.SPORTS
        "Новости" -> Category.NEWS
        "Книги" -> Category.BOOKS
        "Бизнес" -> Category.BUSINESS
        "Финансы" -> Category.FINANCE
        "Путешествия" -> Category.TRAVEL
        "Карты" -> Category.MAPS
        "Еда" -> Category.FOOD
        "Шопинг" -> Category.SHOPPING
        "Утилиты" -> Category.UTILITIES
        else -> throw IllegalStateException("Неподдерживаемый тип категории: $category")
    }
}