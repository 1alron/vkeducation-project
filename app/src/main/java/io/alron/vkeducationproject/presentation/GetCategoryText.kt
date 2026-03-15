package io.alron.vkeducationproject.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import io.alron.vkeducationproject.R
import io.alron.vkeducationproject.domain.Category

@Composable
fun getCategoryText(category: Category): String = when (category) {
    Category.APP -> stringResource(R.string.category_app)
    Category.GAME -> stringResource(R.string.category_game)
}