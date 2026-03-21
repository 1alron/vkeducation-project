package io.alron.vkeducationproject.presentation.appdetails

import io.alron.vkeducationproject.presentation.Category

data class AppDetails(
    val name: String,
    val developer: String,
    val category: Category,
    val ageRating: Int,
    val size: Float,
    val iconUrl: String,
    val screenshotUrlList: List<String>,
    val description: String,
)