package io.alron.vkeducationproject.presentation.applist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.alron.vkeducationproject.domain.AppSummariesRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppListViewModel @Inject constructor(
    private val appSummariesRepository: AppSummariesRepository
) : ViewModel() {
    private val _state = MutableStateFlow<AppListState>(AppListState.Loading)
    val state: StateFlow<AppListState> = _state.asStateFlow()

    private val _events = Channel<ScreenEvent>(Channel.BUFFERED)
    val events = _events.receiveAsFlow()

    init {
        getAppSummaries()
    }

    fun getAppSummaries() {
        viewModelScope.launch {
            runCatching {
                _state.value = AppListState.Loading

                val appSummaries = appSummariesRepository.get()

                _state.value = AppListState.Content(appSummaries)
            }.onFailure {
                _state.value = AppListState.Error
            }
        }
    }

    fun showSnackbar() {
        viewModelScope.launch {
            _events.send(
                ScreenEvent.ShowSnackbar("Лого")
            )
        }
    }
}