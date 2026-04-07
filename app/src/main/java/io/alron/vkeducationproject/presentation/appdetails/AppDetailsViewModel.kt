package io.alron.vkeducationproject.presentation.appdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.alron.vkeducationproject.domain.AppDetailsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppDetailsViewModel @Inject constructor(
    private val appDetailsRepository: AppDetailsRepository
) : ViewModel() {
    private val _state = MutableStateFlow<AppDetailsState>(AppDetailsState.Loading)
    val state: StateFlow<AppDetailsState> = _state.asStateFlow()

    fun startObserving(id: String) {
        observeAppDetails(id)
    }

    fun toggleWishlist(id: String) {
        viewModelScope.launch {
            appDetailsRepository.toggleWishlist(id)
        }
    }

    private fun observeAppDetails(id: String) {
        viewModelScope.launch {
            appDetailsRepository.observeAppDetails(id)
                .catch {
                    _state.value =
                        AppDetailsState.Error(it.localizedMessage ?: "Неизвестная ошибка")
                }
                .collect { appDetails ->
                    _state.value = AppDetailsState.Content(appDetails = appDetails)
                }
        }
    }
}