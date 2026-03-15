package io.alron.vkeducationproject.presentation.applist

import io.alron.vkeducationproject.domain.AppSummary

sealed interface AppListState {
    data object Loading : AppListState
    data object Error : AppListState
    data class Content(
        val appSummaries: List<AppSummary>
    ) : AppListState
}