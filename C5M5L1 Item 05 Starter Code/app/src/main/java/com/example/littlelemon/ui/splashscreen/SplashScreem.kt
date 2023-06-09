package com.example.littlelemon.ui.splashscreen


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun SplashScreen() {
    Surface(color = MaterialTheme.colors.primary) {
        Box(modifier = Modifier.fillMaxSize()) {
            // Customize your splash screen UI here
        }
    }
}
