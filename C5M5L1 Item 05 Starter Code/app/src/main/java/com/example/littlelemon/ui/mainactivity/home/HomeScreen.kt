package com.example.littlelemon.ui.mainactivity.home

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.littlelemon.ui.topbar.TopAppBar
import com.example.littlelemon.data.dishrepository.DishRepository

@Composable
fun HomeScreen(navController: NavHostController,context:Context) {
    Column {

        TopAppBar(null,null,context)
        UpperPanel()
        LowerPanel(navController, DishRepository.dishes)
    }
}
