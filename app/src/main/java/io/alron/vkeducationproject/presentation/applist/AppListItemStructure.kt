package io.alron.vkeducationproject.presentation.applist

import io.alron.vkeducationproject.domain.Category

data class AppListItemStructure(
    val name: String,
    val description: String,
    val category: Category,
    val iconUrl: String,
)