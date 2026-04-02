package io.alron.vkeducationproject.presentation.appdetails

import io.alron.vkeducationproject.domain.AppDetails

sealed interface AppDetailsState {
    data object Loading : AppDetailsState
    data class Error(
        val message: String
    ) : AppDetailsState
    data class Content(
        val appDetails: AppDetails
    ): AppDetailsState
}