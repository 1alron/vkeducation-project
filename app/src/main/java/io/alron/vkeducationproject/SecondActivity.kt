package io.alron.vkeducationproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import io.alron.vkeducationproject.screens.SecondActivityScreen
import io.alron.vkeducationproject.ui.theme.VKEducationProjectTheme

class SecondActivity :  ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val message = getMessageFromFirstActivity()

        setContent {
            VKEducationProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SecondActivityScreen(
                        message = message,
                        modifier = Modifier
                            .padding(innerPadding)
                    )
                }
            }
        }
    }

    private fun getMessageFromFirstActivity(): String {
        return intent.getStringExtra("message") ?: ""
    }
}