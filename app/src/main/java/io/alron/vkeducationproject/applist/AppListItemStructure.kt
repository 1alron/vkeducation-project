package io.alron.vkeducationproject.applist

import io.alron.vkeducationproject.Category

data class AppListItemStructure(
    val name: String,
    val description: String,
    val category: Category,
    val iconUrl: String,
)