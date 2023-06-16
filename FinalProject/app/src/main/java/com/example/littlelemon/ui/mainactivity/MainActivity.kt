package com.example.littlelemon.ui.mainactivity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.littlelemon.destinations.CartItem
import com.example.littlelemon.destinations.DishDetails
import com.example.littlelemon.destinations.Home
import com.example.littlelemon.destinations.MenuList
import com.example.littlelemon.destinations.Profile
import com.example.littlelemon.ui.mainactivity.cartitem.CartScreen
import com.example.littlelemon.ui.mainactivity.dishdetails.DishDetails
import com.example.littlelemon.ui.mainactivity.home.HomeScreen
import com.example.littlelemon.ui.mainactivity.location.ProfileScreen
import com.example.littlelemon.ui.mainactivity.menulist.MenuListScreen
import com.example.littlelemon.ui.theme.LittleLemonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LittleLemonTheme {
                val context = LocalContext.current
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()
                val coroutineScope = rememberCoroutineScope()
                var selectedIndex = rememberSaveable() {
                    mutableStateOf(0)
                }

                Scaffold(
                    scaffoldState = scaffoldState,
                    bottomBar = {

                    }) {
                    Box(Modifier.padding(it)) {
                    }
                    NavHost(navController = navController, startDestination = Home.route) {
                        composable(Home.route) {
                            HomeScreen(navController, scaffoldState, coroutineScope,selectedIndex)
                        }
                        composable(MenuList.route) {
                            MenuListScreen(navController, context,coroutineScope,scaffoldState,selectedIndex)
                        }
                        composable(Profile.route) {
                            ProfileScreen(context, navController,scaffoldState,selectedIndex)
                        }
                        composable(CartItem.route) {
                            CartScreen(navController)

                        }
                        composable(
                            DishDetails.route + "/{${DishDetails.argDishId}}",
                            arguments = listOf(navArgument(DishDetails.argDishId) {
                                type = NavType.IntType
                            })
                        ) {
                            val id =
                                requireNotNull(it.arguments?.getInt(DishDetails.argDishId)) { "Dish id is null" }
                            DishDetails(id, context, navController)
                        }
                        Log.i("destination1","value= ${navController.currentBackStackEntry}")
                    }
                }
            }
        }
    }



}