package com.valu.storeapp.presentation.navigation

sealed class Screens(val route:String){
    object HomeScreen :Screens("home_screen")
    object DetailsScreen :Screens("details_screen")

    fun withArgs(vararg args:String):String{
       return buildString {
           append(route)
           args.forEach { _ ->
               append("/${args[0]}")
           }
       }
    }
}
