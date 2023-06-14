package com.example.littlelemon.ui.splashscreen



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.littlelemon.R
import com.example.littlelemon.ui.theme.LittleLemonColor
import com.example.littlelemon.ui.theme.LittleLemonTheme

@Composable
@Preview(showSystemUi = true)
fun SplashScreen() {
    Column(modifier =  Modifier.fillMaxSize()
        .background(LittleLemonColor.green),
              verticalArrangement = Arrangement.Center,
          horizontalAlignment = Alignment.CenterHorizontally) {
              val composition by rememberLottieComposition(com.airbnb.lottie.compose.LottieCompositionSpec.RawRes(R.raw.lemon))
              val progress by animateLottieCompositionAsState(composition)
              LottieAnimation(
                  composition = composition,
                  progress = { progress },
              )
        Text(
            text = stringResource(id = R.string.title),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = LittleLemonColor.yellow
        )
          }

}
