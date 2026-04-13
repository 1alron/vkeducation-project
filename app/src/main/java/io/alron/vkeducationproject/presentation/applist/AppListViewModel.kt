package io.alron.vkeducationproject.presentation.applist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.alron.vkeducationproject.domain.GetAppSummariesUseCase
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppListViewModel @Inject constructor(
    private val getAppSummariesUseCase: GetAppSummariesUseCase
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
            _state.value = AppListState.Loading

            val result = runCatching {
                getAppSummariesUseCase()
            }

            result.onSuccess { summaries ->
                _state.value = AppListState.Content(summaries)
            }

            result.onFailure { throwable ->
                _state.value = AppListState.Error(
                    throwable.localizedMessage ?: "Неизвестная ошибка"
                )
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