package com.nukte.composefirst.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.nukte.composefirst.navigation.AppNavigation

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AppContent() {
    val navController = rememberNavController()
    AppNavigation(navController = navController)

   /* NavHost(
        navController = navController,
        startDestination = NavRoutes.Home.route,
    ) {
        composable(NavRoutes.Home.route) {
           // HomeScreen(navController = navController)
        }
        composable(
            route = NavRoutes.Detail.route + "/{charId}",
            arguments = listOf(navArgument("charId") { type = NavType.IntType })
        ) { backStackEntry ->
            DetailScreen(navController = navController, backStackEntry)
        }
    }*/
}