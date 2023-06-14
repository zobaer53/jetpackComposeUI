package com.example.littlelemon.data.cartrepository

import androidx.annotation.DrawableRes
import com.example.littlelemon.R
import com.example.littlelemon.data.dishrepository.Dish

data class CartItem(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    @DrawableRes val imageResource: Int
)

