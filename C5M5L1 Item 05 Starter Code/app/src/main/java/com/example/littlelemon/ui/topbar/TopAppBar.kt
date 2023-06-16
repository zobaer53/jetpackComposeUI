package com.example.littlelemon.ui.topbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.littlelemon.R
import com.example.littlelemon.destinations.CartItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import androidx.compose.foundation.layout.*
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.material.Icon
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.IntOffset
import com.example.littlelemon.ui.theme.LittleLemonColor


@Composable
fun TopAppBar(
    scaffoldState: ScaffoldState? = null,
    scope: CoroutineScope? = null,
    navController: NavHostController? = null,
    homePage:Boolean? = false
) {

    Row(horizontalArrangement = Arrangement.SpaceBetween,
    modifier = Modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically) {
      if(homePage == true){
          IconButton(onClick = {
              scope?.launch {
                  scaffoldState?.drawerState?.open()
              }
          }) {
              Image(
                  painter = painterResource(id = R.drawable.ic_hamburger_menu),
                  contentDescription = "Menu Icon",
                  modifier = Modifier.size(24.dp)
              )
          }

      }else{
              IconButton(onClick = {
                  navController?.popBackStack()
              }) {
                  Icon(Icons.Default.ArrowBack, contentDescription = "Back")
              }
          }


        Image(
            painter = painterResource(id = R.drawable.littlelemonimgtxt_nobg),
            contentDescription = "Little Lemon Logo",
            modifier = Modifier
                .fillMaxWidth(0.5F)
                .padding(horizontal = 20.dp)
        )

        IconButton(onClick = {
            navController?.navigate(CartItem.route) {
                launchSingleTop = true
            }
        }) {
            Image(
                painter = painterResource(id = R.drawable.ic_cart),
                contentDescription = "Cart",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
@Composable
fun TransparentDivider(
) {
    Box() {
        IconButton(onClick = {}) {
            Image(
                painter = painterResource(id = R.drawable.transparent),
                contentDescription = "Menu Icon",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}





