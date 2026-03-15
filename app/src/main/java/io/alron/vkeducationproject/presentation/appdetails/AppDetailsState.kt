package io.alron.vkeducationproject.presentation.appdetails

sealed interface AppDetailsState {
    data object Loading : AppDetailsState
    data object Error : AppDetailsState
    data class Content(
        val appDetailsList: List<AppDetails>
    ): AppDetailsState
}