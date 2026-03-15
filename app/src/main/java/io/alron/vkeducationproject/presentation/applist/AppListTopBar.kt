package io.alron.vkeducationproject.presentation.applist

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import io.alron.vkeducationproject.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppListTopBar(
    onLogoClick: () -> Unit,
    onActionClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = onLogoClick) {
                    Icon(
                        painter = painterResource(R.drawable.ic_stacks),
                        contentDescription = null,
                        modifier = Modifier.size(28.dp)
                    )
                }
                Text(
                    text = stringResource(R.string.my_store)
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimary
        ),
        actions = {
            IconButton(
                onClick = { onActionClick() }
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_view_comfy_alt),
                    contentDescription = null
                )
            }
        },
        modifier = modifier
    )
}