package com.example.littlelemon.ui.mainactivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.littlelemon.destinations.DishDetails
import com.example.littlelemon.destinations.Home
import com.example.littlelemon.destinations.MenuList
import com.example.littlelemon.destinations.Profile
import com.example.littlelemon.ui.mainactivity.dishdetails.DishDetails
import com.example.littlelemon.ui.mainactivity.home.HomeScreen
import com.example.littlelemon.ui.mainactivity.location.ProfileScreen
import com.example.littlelemon.ui.mainactivity.menulist.MenuListScreen
import com.example.littlelemon.ui.theme.LittleLemonColor
import com.example.littlelemon.ui.theme.LittleLemonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LittleLemonTheme {
                val navController = rememberNavController()
                Scaffold(bottomBar = { MyBottomNavigation(navController = navController) }) {
                    Box(Modifier.padding(it)){
                }
                    NavHost(navController = navController, startDestination = Home.route) {
                        composable(Home.route) {
                            HomeScreen(navController)
                        }
                        composable(MenuList.route) {
                            MenuListScreen(navController)
                        }
                        composable(Profile.route){
                            ProfileScreen()
                        }
                        composable(
                            DishDetails.route + "/{${DishDetails.argDishId}}",
                            arguments = listOf(navArgument(DishDetails.argDishId) {
                                type = NavType.IntType
                            })
                        ) {
                            val id =
                                requireNotNull(it.arguments?.getInt(DishDetails.argDishId)) { "Dish id is null" }
                            DishDetails(id)
                        }
                    }
                }

                }
        }
    }
@Composable
fun MyBottomNavigation(navController: NavController) {
    val destinationList = listOf(
        Home,
        MenuList,
        Profile
    )
    val selectedIndex = rememberSaveable() {
        mutableStateOf(0)
    }
    BottomNavigation(backgroundColor = LittleLemonColor.cloud) {
        destinationList.forEachIndexed { index, destination ->
            BottomNavigationItem(
                selectedContentColor = LittleLemonColor.green,
                label = { Text(text = destination.title) },
                icon = {
                    Icon(
                        painter = painterResource(id = destination.icon),
                        contentDescription = destination.title
                    )
                },
                selected = index == selectedIndex.value,
                onClick = {
                    selectedIndex.value = index
                    navController.navigate(destinationList[index].route) {
                        popUpTo(Home.route)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}
}
