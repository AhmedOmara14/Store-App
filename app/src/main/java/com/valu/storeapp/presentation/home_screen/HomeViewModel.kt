package com.valu.storeapp.presentation.home_screen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.valu.storeapp.common.Resource
import javax.inject.Inject
import com.valu.storeapp.domain.use_case.get_all_products.GetAllProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class HomeViewModel @Inject constructor(val getAllProductsUseCase: GetAllProductsUseCase) :
    ViewModel() {

    private val _state = mutableStateOf(ListProductsState())
    val listProductsState: State<ListProductsState> = _state


    init {
        getListProducts()
    }

    private fun getListProducts() {
        getAllProductsUseCase().onEach { response ->
            when (response) {
                is Resource.Loading -> {
                    _state.value = ListProductsState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = ListProductsState(
                        allProductsResponse = response.data,
                        isLoading = false
                    )
                }
                is Resource.Error -> {
                    _state.value =
                        ListProductsState(error = response.message ?: "unexpected error")
                }
            }
        }.launchIn(viewModelScope)
    }
}