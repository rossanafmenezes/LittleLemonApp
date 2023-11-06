package com.rossana.littlelemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MenuNetwork(
    val menu: List<MenuItemNetwork>
)

@Serializable
data class MenuItemNetwork(
    @SerialName("id")
    val id: Int,
    @SerialName("title")
    val title: String,
    @SerialName("price")
    val price: Double,
    @SerialName("description")
    val description: String,
    @SerialName("image")
    val image: String
) {
    fun toMenuItemRoom() = MenuItemRoom(
        id = id,
        title = title,
        price = price,
        description = description,
        image = image
    )
}
