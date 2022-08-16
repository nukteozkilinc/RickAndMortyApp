package com.nukte.composefirst.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.nukte.composefirst.navigation.AppNavigation

@Composable
fun AppContent(navController : NavHostController) {
    AppNavigation(navController = navController)
}