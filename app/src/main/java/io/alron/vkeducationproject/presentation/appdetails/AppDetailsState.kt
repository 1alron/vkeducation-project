package io.alron.vkeducationproject.presentation.appdetails

import io.alron.vkeducationproject.domain.AppDetails

sealed interface AppDetailsState {
    data object Loading : AppDetailsState
    data object Error : AppDetailsState
    data class Content(
        val appDetails: AppDetails
    ): AppDetailsState
}