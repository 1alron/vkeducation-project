package io.alron.vkeducationproject.presentation.applist

sealed interface ScreenEvent {
    data object NetworkError : ScreenEvent
    data class ShowSnackbar(val message: String) : ScreenEvent
}