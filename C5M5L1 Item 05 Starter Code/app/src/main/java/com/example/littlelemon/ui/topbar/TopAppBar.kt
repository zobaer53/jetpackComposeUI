package com.example.littlelemon.ui.topbar

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import com.example.littlelemon.R
import com.example.littlelemon.ui.loginactivity.LoginActivity
import com.example.littlelemon.ui.mainactivity.MainActivity
import com.example.littlelemon.ui.mainactivity.cartitem.CartActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@Composable
fun TopAppBar(scaffoldState: ScaffoldState? = null, scope: CoroutineScope? = null, context:Context?=null) {

    Row(horizontalArrangement = Arrangement.SpaceBetween,
    modifier = Modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically) {
        IconButton(onClick = {
            scope?.launch { scaffoldState?.drawerState?.open() }
        }) {
            Image(
                painter = painterResource(id = R.drawable.ic_hamburger_menu),
                contentDescription = "Menu Icon",
                modifier = Modifier.size(24.dp)
            )
        }
        Image(
            painter = painterResource(id = R.drawable.littlelemonimgtxt_nobg),
            contentDescription = "Little Lemon Logo",
            modifier = Modifier
                .fillMaxWidth(0.5F)
                .padding(horizontal = 20.dp)
        )
        val coroutineScope = rememberCoroutineScope()
        IconButton(onClick = {
            coroutineScope.launch {
                // Start the activity here
                context?.startActivity(Intent(context, CartActivity::class.java))
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

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview() {
    TopAppBar()
}
