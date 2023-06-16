package com.example.littlelemon.ui.mainactivity.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import com.example.littlelemon.data.dishrepository.DishRepository
import com.example.littlelemon.ui.mainactivity.bottomnav.MyBottomNavigation
import com.example.littlelemon.ui.mainactivity.drawer.DrawerTopBarScreen
import com.example.littlelemon.ui.topbar.TopAppBar
import kotlinx.coroutines.CoroutineScope

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavHostController,
    scaffoldState: ScaffoldState,
    coroutineScope: CoroutineScope,
    selectedIndex: MutableState<Int>,
) {
    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = {  if (scaffoldState.drawerState.isClosed) {
            MyBottomNavigation(navController = navController,selectedIndex)
        }},
        topBar = { TopAppBar(scaffoldState, coroutineScope, navController,true) },
        drawerContent = {
            DrawerTopBarScreen()
        })
    {

        Column {

            UpperPanel()
            LowerPanel(navController, DishRepository.dishes)
        }
    }

}





