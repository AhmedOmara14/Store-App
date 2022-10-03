package com.valu.storeapp.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.valu.storeapp.presentation.details_screen.ProductDetailsScreen
import com.valu.storeapp.presentation.home_screen.HomeScreen
import com.valu.storeapp.presentation.navigation.Screens

@Composable
fun Navigation(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Screens.HomeScreen.route) {
        composable(route = Screens.HomeScreen.route) {
            HomeScreen(navHostController = navHostController)
        }

        composable(
            route = Screens.DetailsScreen.route + "/{productID}", arguments = listOf(
                navArgument("productID") {
                    defaultValue = ""
                    type = NavType.StringType
                    nullable = true
                }
            )
        ) {
            ProductDetailsScreen()
        }
    }
}