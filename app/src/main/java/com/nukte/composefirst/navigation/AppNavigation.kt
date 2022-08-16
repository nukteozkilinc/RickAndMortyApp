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
import com.nukte.composefirst.presentation.more.MoreScreen
import com.nukte.composefirst.presentation.detail.DetailScreen
import com.nukte.composefirst.presentation.favorite.FavoriteScreen
import com.nukte.composefirst.presentation.home.HomeScreen

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Favorite : Screen("favorite")
}

private sealed class LeafScreen(
    private val route: String,
) {
    fun createRoute(root: Screen) = "${root.route}/$route"

    object Home : LeafScreen("home")
    object Favorite : LeafScreen("favorite")
    object More : LeafScreen("more/{charId}"){
        fun createRoute(root: Screen, charId: Int): String {
            return "${root.route}/more/${charId}"
        }
    }
    object Details : LeafScreen("detail/{charId}") {
        fun createRoute(root: Screen, charId: Int): String {
            return "${root.route}/detail/${charId}"
        }
    }
}

@Composable
internal fun AppNavigation(
    navController: NavHostController
) {
    NavHost(navController = navController,
        startDestination = Screen.Home.route,
        modifier = Modifier) {
        addHomeTopLevel(navController)
        addFavoriteTopLevel(navController)
    }
}

private fun NavGraphBuilder.addHomeTopLevel(
    navController: NavController,
) {
    navigation(route = Screen.Home.route,
        startDestination = LeafScreen.Home.createRoute(Screen.Home)) {
        addHomeScreen(navController, Screen.Home)
        addDetailScreen(navController, Screen.Home)
        addMoreScreen(navController,Screen.Home)
    }
}

private fun NavGraphBuilder.addFavoriteTopLevel(
    navController: NavController,
) {
    navigation(route = Screen.Favorite.route,
        startDestination = LeafScreen.Favorite.createRoute(Screen.Favorite)) {
        addFavoriteScreen(navController,Screen.Favorite)
    }
}


@OptIn(ExperimentalFoundationApi::class)
private fun NavGraphBuilder.addHomeScreen(
    navController: NavController,
    root: Screen,
) {
    composable(route = LeafScreen.Home.createRoute(root)) {
        HomeScreen(
            showDetail = {
                navController.navigate(LeafScreen.Details.createRoute(root, it))
            }
            )
    }
}
@OptIn(ExperimentalFoundationApi::class)
private fun NavGraphBuilder.addFavoriteScreen(
    navController: NavController,
    root: Screen,
) {
    composable(route = LeafScreen.Favorite.createRoute(root)) {
        FavoriteScreen(
        )
    }
}

private fun NavGraphBuilder.addDetailScreen(
    navController: NavController,
    root: Screen,
) {
    composable(route = LeafScreen.Details.createRoute(root),
        arguments = listOf(navArgument("charId") { type = NavType.IntType })) {
        DetailScreen(
            openUser = { navController.navigate(LeafScreen.Home.createRoute(root)) },
            showMore = {navController.navigate(LeafScreen.More.createRoute(root,it))}

        )
    }
}

private fun NavGraphBuilder.addMoreScreen(
    navController: NavController,
    root: Screen
){
    composable(route = LeafScreen.More.createRoute(root),
    arguments = listOf(navArgument("charId"){type = NavType.IntType})
        ){
        MoreScreen(
            openUser = {navController.navigate(LeafScreen.Home.createRoute(root))}
        )
    }
}