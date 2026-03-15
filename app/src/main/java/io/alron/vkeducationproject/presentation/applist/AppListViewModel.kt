package io.alron.vkeducationproject.presentation.applist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.alron.vkeducationproject.data.AppSummariesApi
import io.alron.vkeducationproject.data.AppSummariesRepositoryMockImpl
import io.alron.vkeducationproject.data.AppSummaryMapper
import io.alron.vkeducationproject.data.CategoryMapper
import io.alron.vkeducationproject.domain.AppSummariesRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class AppListViewModel : ViewModel() {
    // В будущем применим DI
    private val appSummariesRepository: AppSummariesRepository = AppSummariesRepositoryMockImpl(
        mapper = AppSummaryMapper(
            CategoryMapper()
        ),
        api = AppSummariesApi()
    )
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