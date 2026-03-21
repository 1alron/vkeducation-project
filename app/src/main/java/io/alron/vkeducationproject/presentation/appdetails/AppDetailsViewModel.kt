package io.alron.vkeducationproject.presentation.appdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.alron.vkeducationproject.domain.AppDetailsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppDetailsViewModel @Inject constructor(
    private val appDetailsRepository: AppDetailsRepository
): ViewModel() {
    private val _state = MutableStateFlow<AppDetailsState>(AppDetailsState.Loading)
    val state: StateFlow<AppDetailsState> = _state.asStateFlow()

    init {
        getAppDetails()
    }

    fun getAppDetails() {
        viewModelScope.launch {
            runCatching {
                _state.value = AppDetailsState.Loading

                val appDetails = appDetailsRepository.get("тут должен быть id :)")

                _state.value = AppDetailsState.Content(appDetails)
            }.onFailure {
                _state.value = AppDetailsState.Error
            }
        }
    }
}