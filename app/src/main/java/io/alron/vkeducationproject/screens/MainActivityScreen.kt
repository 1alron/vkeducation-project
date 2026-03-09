package io.alron.vkeducationproject.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import io.alron.vkeducationproject.R

@Composable
fun MainActivityScreen(
    onOpenSecondActivityScreen: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var textFieldValue by rememberSaveable { mutableStateOf("") }
    var textFieldSupportingTextId: Int? by rememberSaveable { mutableStateOf(null) }

    fun validateTextField(): Boolean {
        if (textFieldValue.isBlank()) {
            textFieldSupportingTextId = R.string.field_cannot_be_empty
            return false
        }
        return true
    }

    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .widthIn(max = 540.dp)
        ) {
            OutlinedTextField(
                value = textFieldValue,
                onValueChange = {
                    textFieldSupportingTextId = null
                    textFieldValue = it
                },
                label = { Text(stringResource(R.string.input_text)) },
                isError = textFieldSupportingTextId != null,
                supportingText = if (textFieldSupportingTextId != null) {
                    {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Warning,
                                contentDescription = stringResource(R.string.warning_icon),
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(Modifier.width(4.dp))
                            Text(
                                text = stringResource(textFieldSupportingTextId!!)
                            )
                        }
                    }
                } else null,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(12.dp))
            Button(
                onClick = {
                    if (validateTextField()) {
                        onOpenSecondActivityScreen(textFieldValue)
                    }
                },
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(stringResource(R.string.open_second_activity))
            }
        }
    }
}