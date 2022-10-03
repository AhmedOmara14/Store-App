package com.valu.storeapp.presentation.home_screen

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.valu.storeapp.R
import com.valu.storeapp.presentation.home_screen.component.ProductItem
import com.valu.storeapp.presentation.navigation.Screens


@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navHostController: NavHostController
) {
    val listProductsState = viewModel.listProductsState.value
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column {
            Text(
                "All Products", textAlign = TextAlign.Center, style = TextStyle(
                    fontSize = 20.sp,
                    color = colorResource(id = R.color.black),
                    fontFamily = FontFamily(
                        Font(R.font.font_bold)
                    )
                ), modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp, top = 10.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))

            listProductsState.allProductsResponse?.let {
                ProductItem(
                    items_ = it, onExecuteMovie = {
                        navHostController.navigate(Screens.DetailsScreen.withArgs(it))
                    }
                )
            }
        }

        if (listProductsState.error.isNotBlank()) {
            Toast.makeText(context, listProductsState.error, Toast.LENGTH_SHORT).show()
        }
        if (listProductsState.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

    }
}

