package com.nukte.composefirst.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nukte.composefirst.navigation.NavRoutes
import com.nukte.composefirst.presentation.detail.DetailScreen
import com.nukte.composefirst.presentation.home.HomeScreen

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AppContent() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoutes.Home.route, ){
        composable(NavRoutes.Home.route){
            HomeScreen(navController = navController)
        }
        composable(NavRoutes.Detail.route){
            DetailScreen(navController = navController)
        }
    }

}