package com.example.littlelemon.ui.mainactivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.NavController
import androidx.navigation.NavHostController
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
import com.example.littlelemon.ui.theme.LittleLemonColor
import com.example.littlelemon.ui.theme.LittleLemonTheme
import kotlinx.coroutines.CoroutineScope

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LittleLemonTheme {
                val context = LocalContext.current
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()
                val coroutineScope = rememberCoroutineScope()
                val visible by remember { mutableStateOf(true) }

                Scaffold(
                    scaffoldState = scaffoldState,
                    bottomBar = {
                        if (scaffoldState.drawerState.isClosed) {
                            AnimateSlide(
                                visible = visible,
                                navController
                            )

                        }else{
                            AnimateSlide(
                                visible = false,
                                navController
                            )
                        }

                    }) {
                    Box(Modifier.padding(it)) {
                    }
                    NavHost(navController = navController, startDestination = Home.route) {
                        composable(Home.route) {
                            HomeScreen(navController, scaffoldState, coroutineScope)
                        }
                        composable(MenuList.route) {
                            MenuListScreen(navController, context)
                        }
                        composable(Profile.route) {
                            ProfileScreen(context, navController)
                        }
                        composable(CartItem.route) {
                            CartScreen(context = context, navController)
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

    @Composable
    fun AnimateSlide(
        visible: Boolean,
        navController: NavHostController
    ) {

        AnimatedVisibility(
            visible,
            enter = slideIn(tween(500, easing = LinearOutSlowInEasing)) { fullSize ->
                // Specifies the starting offset of the slide-in to be 1/4 of the width to the right,
                // 100 (pixels) below the content position, which results in a simultaneous slide up
                // and slide left.
                IntOffset(fullSize.width / 4, 200)
            },
            exit = slideOut(tween(500, easing = FastOutSlowInEasing)) {
                // The offset can be entirely independent of the size of the content. This specifies
                // a target offset 180 pixels to the left of the content, and 50 pixels below. This will
                // produce a slide-left combined with a slide-down.
                IntOffset(-280, 50)
            },
        ) {
            // Content that needs to appear/disappear goes here:
            /*    Text("Content to appear/disappear",
                Modifier
                    .fillMaxWidth()
                    .requiredHeight(200.dp))*/

            MyBottomNavigation(navController = navController)
        }
    }
}