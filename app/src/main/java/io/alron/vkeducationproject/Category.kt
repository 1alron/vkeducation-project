package io.alron.vkeducationproject

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

enum class Category {
    APP, GAME
}

// Статичные строки, которые не приходят из бэкенда
// нужно хранить в ресурсах (strings.xml).
@Composable
fun getCategoryText(category: Category): String = when (category) {
    Category.APP -> stringResource(R.string.category_app)
    Category.GAME -> stringResource(R.string.category_game)
}