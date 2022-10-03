package com.valu.storeapp.domain.repository


import com.valu.storeapp.domain.model.all_products.AllProductsResponse
import com.valu.storeapp.domain.model.product_details.ProductDetails


interface Repository {
    suspend fun getProducts(): AllProductsResponse
    suspend fun getProductDetailsById(id: String): ProductDetails
}