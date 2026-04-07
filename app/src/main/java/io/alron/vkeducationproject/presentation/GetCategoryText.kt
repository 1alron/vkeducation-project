package io.alron.vkeducationproject.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import io.alron.vkeducationproject.R
import io.alron.vkeducationproject.domain.Category

@Composable
fun getCategoryText(category: Category): String = when (category) {
    Category.APP -> "Приложения"
    Category.GAME -> "Игры"
    Category.PRODUCTIVITY -> "Производительность"
    Category.SOCIAL -> "Социальные сети"
    Category.EDUCATION -> "Образование"
    Category.ENTERTAINMENT -> "Развлечения"
    Category.MUSIC -> "Музыка"
    Category.VIDEO -> "Видео"
    Category.PHOTOGRAPHY -> "Фотография"
    Category.HEALTH -> "Здоровье"
    Category.HEALTH_AND_FITNESS -> "Здоровье и фитнес"
    Category.PHOTO_AND_VIDEO -> "Фото и видео"
    Category.FOOD_AND_DRINKS -> "Еда и напитки"
    Category.LIFESTYLE -> "Образ жизни"
    Category.NAVIGATION -> "Навигация"
    Category.CHATTING -> "Общение"
    Category.WEATHER -> "Погода"
    Category.BOOKS_AND_REFERENCES -> "Книги и справочники"
    Category.SPORTS -> "Спорт"
    Category.NEWS -> "Новости"
    Category.BOOKS -> "Книги"
    Category.BUSINESS -> "Бизнес"
    Category.FINANCE -> "Финансы"
    Category.TRAVEL -> "Путешествия"
    Category.MAPS -> "Карты"
    Category.FOOD -> "Еда"
    Category.SHOPPING -> "Шопинг"
    Category.UTILITIES -> "Утилиты"
}