package com.valu.storeapp.domain.use_case.get_all_products

import android.util.Log
import com.valu.storeapp.common.Resource
import com.valu.storeapp.domain.model.all_products.AllProductsResponse
import com.valu.storeapp.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAllProductsUseCase @Inject constructor(val repository: Repository) {
    operator fun invoke(
    ): Flow<Resource<AllProductsResponse>> = flow {
        try {
            emit(Resource.Loading<AllProductsResponse>())
            val movies = repository.getProducts()
            Log.d("TAG", "invoke: "+movies)
            emit(Resource.Success<AllProductsResponse>(movies))
        } catch (e: HttpException) {
            emit(Resource.Error<AllProductsResponse>(e.localizedMessage ?: "an Error Occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<AllProductsResponse>("No Internet Connection, Check your Internet"))
        }
    }
}