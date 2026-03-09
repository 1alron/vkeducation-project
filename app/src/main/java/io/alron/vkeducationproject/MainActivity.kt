package io.alron.vkeducationproject

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.net.toUri
import io.alron.vkeducationproject.screens.MainActivityScreen
import io.alron.vkeducationproject.ui.theme.VKEducationProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VKEducationProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainActivityScreen(
                        onOpenSecondActivityScreen = { message ->
                            onOpenSecondActivity(message)
                        },
                        onCall = { phoneNumber ->
                            onCall(phoneNumber)
                        },
                        onShare = { message ->
                            onShare(message)
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    private fun onOpenSecondActivity(message: String) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("message", message)
        startActivity(intent)
    }

    private fun onCall(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = "tel:$phoneNumber".toUri()
        }
        startActivity(intent)
    }

    private fun onShare(message: String) {
        val intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, message)
            type = "text/plain"
        }
        val chooser = Intent.createChooser(intent, "Поделиться через...")
        startActivity(chooser)
    }
}