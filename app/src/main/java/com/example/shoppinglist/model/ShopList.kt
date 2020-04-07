package com.example.shoppinglist.model

import java.io.Serializable

data class ShopList(
    var name: String,
    var price: String,
    var description: String,
    var image: Int
): Serializable