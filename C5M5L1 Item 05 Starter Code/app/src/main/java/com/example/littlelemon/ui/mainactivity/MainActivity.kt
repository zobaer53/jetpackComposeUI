package com.example.littlelemon.ui.mainactivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.littlelemon.destinations.DishDetails
import com.example.littlelemon.destinations.Home
import com.example.littlelemon.ui.mainactivity.dishdetails.DishDetails
import com.example.littlelemon.ui.mainactivity.home.HomeScreen
import com.example.littlelemon.ui.theme.LittleLemonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LittleLemonTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Home.route) {
                    composable(Home.route) {
                        HomeScreen(navController)
                    }
                    composable(
                        DishDetails.route + "/{${DishDetails.argDishId}}",
                        arguments = listOf(navArgument(DishDetails.argDishId) { type = NavType.IntType })
                    ) {
                        val id = requireNotNull(it.arguments?.getInt(DishDetails.argDishId)) { "Dish id is null" }
                        DishDetails(id)
                    }
                }
            }
        }
    }
}
