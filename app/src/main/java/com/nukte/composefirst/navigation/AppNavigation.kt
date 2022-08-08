
package com.nukte.composefirst.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.nukte.composefirst.presentation.detail.DetailScreen
import com.nukte.composefirst.presentation.home.HomeScreen

internal sealed class Screen(val route : String){
    object Home : Screen("home")
    object Detail : Screen("detail")
}

private sealed class LeafScreen(
    private val route : String
){
    fun createRoute(root:Screen) = "${root.route}/$route"

    object Home : LeafScreen("home")
    object Detail : LeafScreen("detail")
}

@Composable
internal fun AppNavigation(
    navController : NavHostController,
    modifier : Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = Modifier
    ){
        addHomeTopLevel(navController)
        addDetailsTopLevel(navController)
    }
}

private fun NavGraphBuilder.addHomeTopLevel(
    navController: NavController
){
    navigation(
        route = Screen.Home.route,
        startDestination = LeafScreen.Home.createRoute(Screen.Home)
    ){
        addHomeScreen(navController,Screen.Home)
        addDetailScreen(navController,Screen.Home)
    }
}

private fun NavGraphBuilder.addDetailsTopLevel(
    navController: NavController
){
    navigation(
        route = Screen.Detail.route,
        startDestination = LeafScreen.Detail.createRoute(Screen.Detail)
    ){
        addHomeScreen(navController,Screen.Detail)
        addDetailScreen(navController,Screen.Detail)
    }
}


@OptIn(ExperimentalFoundationApi::class)
private fun NavGraphBuilder.addHomeScreen(
    navController: NavController,
    root : Screen
){
    composable(
        route = LeafScreen.Home.createRoute(root)
    ){
        HomeScreen(
            openUser = {navController.navigate(LeafScreen.Detail.createRoute(root))}
        )
    }
}

private fun NavGraphBuilder.addDetailScreen(
    navController: NavController,
    root : Screen
){
    composable(
        route = LeafScreen.Detail.createRoute(root)
    ){
        DetailScreen(
            openUser = {navController.navigate(LeafScreen.Home.createRoute(root))}
        )
    }
}

