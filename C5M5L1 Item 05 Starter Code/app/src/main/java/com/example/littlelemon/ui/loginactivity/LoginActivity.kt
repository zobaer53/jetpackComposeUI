package com.example.littlelemon.ui.loginactivity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.littlelemon.R
import com.example.littlelemon.ui.mainactivity.MainActivity
import com.example.littlelemon.ui.theme.LittleLemonColor
import com.example.littlelemon.ui.theme.LittleLemonTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}

@Composable
fun LoginScreen(){
    val context = LocalContext.current
    var userNameTextField by remember {
        mutableStateOf("")
    }
    var userPasswordTextField by remember {
        mutableStateOf("")
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.littlelemonlogo
            ),
            contentDescription = "Logo Image",
            modifier = Modifier.padding(bottom = 10.dp)
        )

        TextField(
            value = userNameTextField,
            onValueChange = {userNameTextField = it},
            label = { Text(text = "Username") },
            modifier = Modifier.padding(bottom = 10.dp),

        )
        TextField(
            value = userPasswordTextField,
            onValueChange = {userPasswordTextField = it},
            label = { Text(text = "Password") },
        )
        Button(
            onClick = {
                context.startActivity(Intent(context, MainActivity::class.java))
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = LittleLemonColor.yellow
            ),
            modifier = Modifier.padding(top = 10.dp)
                .clip(shape = RoundedCornerShape(5.dp))
        ) {
            Text(
                text = "Login"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview(){
    LoginScreen()
}