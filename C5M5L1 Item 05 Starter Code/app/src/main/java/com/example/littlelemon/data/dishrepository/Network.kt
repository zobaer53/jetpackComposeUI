package com.example.littlelemon.data.dishrepository

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class MenuNetwork(

    @SerialName("menu")
    val items: List<com.example.littlelemon.data.dishrepository.MenuItemNetwork>
)

@Serializable
data class MenuItemNetwork(
    @SerialName("id")
    val id: Int,

    @SerialName("title")
    val title: String,

    @SerialName("description")
    val description: String,

    @SerialName("price")
    val price: Double,

    @SerialName("category")
    val category: String,

    @SerialName("image")
    val imageUrl: String
){
    fun toMenuItemRoom() = com.example.littlelemon.data.dishrepository.MenuItemRoom(
        id = id,
        title = title,
        price = price,
        description = description,
        category = category,
        imageUrl = imageUrl
    )
}