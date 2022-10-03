package com.valu.storeapp.presentation.details_screen

import com.valu.storeapp.domain.model.product_details.ProductDetails


data class DetailsProductState(
    val isLoading: Boolean = false,
    val productDetails: ProductDetails? = null,
    val error: String = ""
)