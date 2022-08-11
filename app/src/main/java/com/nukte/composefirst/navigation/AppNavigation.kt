package com.nukte.composefirst.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.nukte.composefirst.presentation.detail.DetailScreen
import com.nukte.composefirst.presentation.home.HomeScreen

internal sealed class Screen(val route: String) {
    object Home : Screen("home")
}

private sealed class LeafScreen(
    private val route: String,
) {
    fun createRoute(root: Screen) = "${root.route}/$route"

    object Home : LeafScreen("home")
    object Details : LeafScreen("detail/{charId}") {
        fun createRoute(root: Screen, charId: Int): String {
            return "${root.route}/detail/${charId}"
        }
    }
}

@Composable
internal fun AppNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(navController = navController,
        startDestination = Screen.Home.route,
        modifier = Modifier) {
        addHomeTopLevel(navController)
    }
}

private fun NavGraphBuilder.addHomeTopLevel(
    navController: NavController,
) {
    navigation(route = Screen.Home.route,
        startDestination = LeafScreen.Home.createRoute(Screen.Home)) {
        addHomeScreen(navController, Screen.Home)
        addDetailScreen(navController, Screen.Home)
    }
}


@OptIn(ExperimentalFoundationApi::class)
private fun NavGraphBuilder.addHomeScreen(
    navController: NavController,
    root: Screen,
) {
    composable(route = LeafScreen.Home.createRoute(root)) {
        HomeScreen(
            //openUser = {navController.navigate(LeafScreen.Details.createRoute(root))},
            showDetail = {
                navController.navigate(LeafScreen.Details.createRoute(root, it))
            })
    }
}


private fun NavGraphBuilder.addDetailScreen(
    navController: NavController,
    root: Screen,
) {
    composable(route = LeafScreen.Details.createRoute(root),
        arguments = listOf(navArgument("charId") { type = NavType.IntType })) {
        DetailScreen(openUser = { navController.navigate(LeafScreen.Home.createRoute(root)) })
    }
}