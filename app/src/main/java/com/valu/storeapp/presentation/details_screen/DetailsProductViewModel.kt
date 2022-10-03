package com.valu.storeapp.presentation.details_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.valu.storeapp.common.Constants
import com.valu.storeapp.common.Resource
import com.valu.storeapp.domain.use_case.get_details_products.GetDetailsProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailsProductViewModel
@Inject constructor(
    val getDetailsProductUseCase: GetDetailsProductUseCase,
    savedStateHandle: SavedStateHandle,
) :
    ViewModel() {

    private val _state = mutableStateOf(DetailsProductState())
    val detailsProductState: State<DetailsProductState> = _state

    init {
        savedStateHandle.get<String>(Constants.PRODUCT_ID)?.let { id ->
            getDetailsProductById(id)
        }
    }

    private fun getDetailsProductById(productID: String) {
        getDetailsProductUseCase(productID).onEach { response ->
            when (response) {
                is Resource.Success -> {
                    _state.value = DetailsProductState(
                        productDetails = response.data
                    )
                }
                is Resource.Error -> {
                    _state.value =
                        DetailsProductState(error = response.message ?: "unexpected error")
                }
                is Resource.Loading -> {
                    _state.value = DetailsProductState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }



}