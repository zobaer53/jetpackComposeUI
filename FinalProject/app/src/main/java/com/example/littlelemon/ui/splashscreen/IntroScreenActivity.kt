package com.example.littlelemon.ui.splashscreen

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.example.littlelemon.ui.loginactivity.LoginActivity
import com.example.littlelemon.ui.loginactivity.LoginScreen
import com.example.littlelemon.ui.mainactivity.MainActivity
import com.example.littlelemon.ui.theme.LittleLemonTheme

class IntroScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            LittleLemonTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                        SplashScreen()
                    Thread {
                        // Simulate some time-consuming task
                        Thread.sleep(2000)

                        // Start the next activity
                        startActivity(Intent(this, LoginActivity::class.java))
                        finish()
                    }.start()
                }
            }
        }
    }
}
