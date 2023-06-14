package com.example.littlelemon.destinations

import com.example.littlelemon.R

interface Destinations {
    val route: String
}
object DishDetails : Destinations {
    override val route = "Menu"
    const val argDishId = "dishId"
}
object CartItem : Destinations {
    override val route = "Cart"
 /*   const val argDishId = "dishId"*/
}

interface DestinationsTabbed {
    val route: String
    val icon: Int
    val title: String
}


object MenuList : DestinationsTabbed {
    override val route = "Menu"
    override val icon = R.drawable.ic_menu
    override val title = "Menu"
}


object Home : DestinationsTabbed {
    override val route = "Home"
    override val icon = R.drawable.ic_home
    override val title = "Home"
}


object Profile : DestinationsTabbed {
    override val route = "Profile"
    override val icon = R.drawable.person_icon
    override val title = "Profile"
}