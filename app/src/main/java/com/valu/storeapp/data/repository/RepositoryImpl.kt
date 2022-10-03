package com.valu.storeapp.data.repository

import com.valu.storeapp.data.remote.Api
import com.valu.storeapp.domain.model.all_products.AllProductsResponse
import com.valu.storeapp.domain.model.product_details.ProductDetails
import com.valu.storeapp.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(val api: Api) : Repository {
    override suspend fun getProducts(): AllProductsResponse {
        return api.getProducts()
    }

    override suspend fun getProductDetailsById(id: String): ProductDetails {
        return api.getProductDetailsById(id)
    }


}