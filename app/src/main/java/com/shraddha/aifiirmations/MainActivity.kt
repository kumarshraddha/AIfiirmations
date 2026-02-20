package com.shraddha.aifiirmations  // <--- UPDATED to match your folder path

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.shraddha.aifiirmations.ui.theme.AIfiirmationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // FIX IS HERE: We use curly braces { } to wrap the app inside the theme
            AIfiirmationsTheme {
                AIffirmationsApp()
            }
        }
    }
}

@Composable
fun AIffirmationsApp() {
    // 1. STATE: Are we on the Home Screen?
    var isHomeScreen by remember { mutableStateOf(value = true) }

    // 2. STATE: What is the current affirmation?
    var currentAffirmation by remember { mutableStateOf(Datasource.affirmations.random()) }

    if (isHomeScreen) {
        HomeScreen(
            onAffirmMeClick = {
                currentAffirmation = Datasource.affirmations.random()
                isHomeScreen = false
            },
        )
    } else {
        AffirmationScreen(
            affirmation = currentAffirmation,
            onHomeClick = { isHomeScreen = true },
        ) { currentAffirmation = Datasource.affirmations.random() }
    }
}