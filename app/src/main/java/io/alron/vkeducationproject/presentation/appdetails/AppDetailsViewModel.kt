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

    fun getAppDetails(id: String) {
        viewModelScope.launch {
            _state.value = AppDetailsState.Loading

            val result = runCatching {
                appDetailsRepository.get(id)
            }

            result.onSuccess { appDetails ->
                _state.value = AppDetailsState.Content(appDetails)
            }

            // аналогично, не очень юзер-френдли, но для учебного проекта думаю сойдет :)
            result.onFailure { throwable ->
                _state.value = AppDetailsState.Error(
                    throwable.localizedMessage ?: "Неизвестная ошибка"
                )
            }
        }
    }
}