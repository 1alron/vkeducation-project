package io.alron.vkeducationproject.presentation.applist

import io.alron.vkeducationproject.domain.AppSummary

sealed interface AppListState {
    data object Loading : AppListState
    data class Error(val message: String) : AppListState
    data class Content(
        val appSummaries: List<AppSummary>
    ) : AppListState
}