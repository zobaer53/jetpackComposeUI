package com.example.littlelemon.ui.mainactivity.home

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.littlelemon.ui.topbar.TopAppBar
import com.example.littlelemon.data.dishrepository.DishRepository

@Composable
fun HomeScreen(navController: NavHostController) {
    Column {
        TopAppBar()
        UpperPanel()
        LowerPanel(navController, DishRepository.dishes)
    }
}
