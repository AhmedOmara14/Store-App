package com.valu.storeapp.data.remote

import com.valu.storeapp.domain.model.all_products.AllProductsResponse
import com.valu.storeapp.domain.model.product_details.ProductDetails
import retrofit2.http.GET
import retrofit2.http.Path


interface Api {
    @GET("products")
    suspend fun getProducts(
    ): AllProductsResponse

    @GET("products/{id}")
    suspend fun getProductDetailsById(
        @Path("id") movie: String,
    ): ProductDetails
}