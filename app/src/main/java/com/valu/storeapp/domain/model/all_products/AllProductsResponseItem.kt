package com.valu.storeapp.domain.model.all_products

data class AllProductsResponseItem(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val title: String
)