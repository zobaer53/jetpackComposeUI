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
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.IntOffset


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
          var visible by remember { mutableStateOf(true) }
          AnimateSlide(visible,scope,scaffoldState)

      }else{
         /* Divider(
              modifier = Modifier.size(24.dp)
                  .background(LittleLemonColor.cloud)
                  .padding(start = 5.dp)

          )*/
          TransparentDivider()
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

@Composable
fun AnimateSlide(visible: Boolean, scope: CoroutineScope?, scaffoldState: ScaffoldState?) {

    AnimatedVisibility(
        visible,
        enter = slideIn(tween(100, easing = LinearOutSlowInEasing)) { fullSize ->
            // Specifies the starting offset of the slide-in to be 1/4 of the width to the right,
            // 100 (pixels) below the content position, which results in a simultaneous slide up
            // and slide left.
            IntOffset(fullSize.width / 4, 100)
        },
        exit = slideOut(tween(100, easing = FastOutSlowInEasing)) {
            // The offset can be entirely independent of the size of the content. This specifies
            // a target offset 180 pixels to the left of the content, and 50 pixels below. This will
            // produce a slide-left combined with a slide-down.
            IntOffset(-180, 50)
        },
    ) {
        // Content that needs to appear/disappear goes here:
    /*    Text("Content to appear/disappear",
            Modifier
                .fillMaxWidth()
                .requiredHeight(200.dp))*/
        IconButton(onClick = {
            scope?.launch { scaffoldState?.drawerState?.open() }
        }) {
            Image(
                painter = painterResource(id = R.drawable.ic_hamburger_menu),
                contentDescription = "Menu Icon",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}




