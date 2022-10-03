package com.valu.storeapp.domain.model.product_details

data class ProductDetails(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
)