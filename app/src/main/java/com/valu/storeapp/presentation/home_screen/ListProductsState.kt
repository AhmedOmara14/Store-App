package com.valu.storeapp.presentation.home_screen

import com.valu.storeapp.domain.model.all_products.AllProductsResponse

data class ListProductsState(
    val isLoading: Boolean = false,
    val allProductsResponse: AllProductsResponse? = null,
    val error: String = ""
)