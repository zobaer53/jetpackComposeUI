package com.example.littlelemon.destinations

interface Destinations {
    val route: String
}

object Home : Destinations {
    override val route = "Home"
}
object Login : Destinations {
    override val route = "Login"
}

object DishDetails : Destinations {
    override val route = "Menu"
    const val argDishId = "dishId"
}
