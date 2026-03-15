package io.alron.vkeducationproject.presentation.applist

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import io.alron.vkeducationproject.R
import io.alron.vkeducationproject.domain.AppSummary
import io.alron.vkeducationproject.presentation.theme.VKEducationProjectTheme
import kotlinx.coroutines.flow.Flow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppListScreen(
    onAppClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val viewModel = viewModel<AppListViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    when (val currentState = state) {
        is AppListState.Content -> {
            AppListContent(
                modifier = modifier,
                onAppClick = onAppClick,
                onLogoClick = { viewModel.showSnackbar() },
                events = viewModel.events,
                appSummaries = currentState.appSummaries
            )
        }

        AppListState.Error -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(stringResource(R.string.error))
            }
        }

        AppListState.Loading -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
    }
}

@Composable
private fun AppListContent(
    events: Flow<ScreenEvent>,
    onLogoClick: () -> Unit,
    appSummaries: List<AppSummary>,
    onAppClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val underDevelopmentText = stringResource(R.string.under_developement)

    val networkErrorText = stringResource(R.string.network_error)
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(events) {
        events.collect { event ->
            when (event) {
                is ScreenEvent.ShowSnackbar -> {
                    snackbarHostState.showSnackbar(event.message)
                }
                is ScreenEvent.NetworkError -> {
                    snackbarHostState.showSnackbar(networkErrorText)
                }
            }
        }
    }

    Scaffold(
        topBar = {
            AppListTopBar(
                onActionClick = {
                    Toast
                        .makeText(context, underDevelopmentText, Toast.LENGTH_SHORT)
                        .show()
                },
                onLogoClick = onLogoClick
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
            modifier = modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            itemsIndexed(
                appSummaries,
            ) { index, item ->
                AppListItem(
                    appSummary = item,
                    onClick = {
                        onAppClick(index)
                    }
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun AppListScreenPreview() {
    VKEducationProjectTheme {
        AppListScreen(
            onAppClick = { }
        )
    }
}
