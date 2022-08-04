package com.nukte.composefirst.navigation

sealed class NavRoutes(val route :String) {
    object Home : NavRoutes("home")
    object Detail : NavRoutes("detail")
}