package io.alron.vkeducationproject.presentation.applist

sealed interface AppListState {
    data object Loading : AppListState
    data object Error : AppListState
    data class Content(
        val appListItemStructureList: List<AppListItemStructure>
    ) : AppListState
}