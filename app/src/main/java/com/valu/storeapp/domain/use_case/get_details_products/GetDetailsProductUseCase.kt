package com.valu.storeapp.domain.use_case.get_details_products

import com.valu.storeapp.common.Resource
import com.valu.storeapp.domain.model.product_details.ProductDetails
import com.valu.storeapp.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetDetailsProductUseCase @Inject constructor(val repository: Repository) {
    operator fun invoke(productID: String):
            Flow<Resource<ProductDetails>> = flow {
        try {
            emit(Resource.Loading<ProductDetails>())
            val details = repository.getProductDetailsById(productID)
            emit(Resource.Success<ProductDetails>(details))
        } catch (e: retrofit2.HttpException) {
            emit(Resource.Error<ProductDetails>(e.localizedMessage ?: "an Error Occurred"))
        } catch (e: java.io.IOException) {
            emit(Resource.Error<ProductDetails>("No Internet Connection, Check your Internet"))
        }

    }
}