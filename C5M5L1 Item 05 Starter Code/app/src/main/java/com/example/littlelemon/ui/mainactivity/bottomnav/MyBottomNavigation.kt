package com.example.littlelemon.ui.mainactivity.bottomnav

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.littlelemon.destinations.CartItem
import com.example.littlelemon.destinations.Home
import com.example.littlelemon.destinations.MenuList
import com.example.littlelemon.destinations.Profile
import com.example.littlelemon.ui.theme.LittleLemonColor

@Composable
fun MyBottomNavigation(navController: NavController, selectedIndex: MutableState<Int>) {
    if(navController.currentDestination?.route != CartItem.route){
        val destinationList = listOf(
            Home,
            MenuList,
            Profile
        )

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