package com.nukte.composefirst

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController
import com.nukte.composefirst.components.AppContent
import com.nukte.composefirst.drawer.AppBar
import com.nukte.composefirst.drawer.DrawerBody
import com.nukte.composefirst.drawer.DrawerHeader
import com.nukte.composefirst.drawer.MenuItem
import com.nukte.composefirst.navigation.Screen
import com.nukte.composefirst.ui.theme.RickAndMorty
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMorty {
                val scaffoldState = rememberScaffoldState()
                val scope = rememberCoroutineScope()
                val navController = rememberNavController()
                Scaffold(
                    scaffoldState=scaffoldState,
                    topBar = {
                             AppBar(
                                 onNavigationClick = {
                                     scope.launch {
                                         scaffoldState.drawerState.open()
                                     }
                                 }
                             )
                    },
                    drawerContent = {
                        DrawerHeader()
                        DrawerBody(
                            items = listOf(
                                MenuItem(
                                    id = "home",
                                    title = "Home",
                                    screen = Screen.Home
                                ),
                                MenuItem(
                                    id = "favorite",
                                    title = "Favorite",
                                    screen = Screen.Favorite
                                )
                            ),
                            onItemClick ={
                                scope.launch {
                                    navController.navigate(it.route)
                                    scaffoldState.drawerState.close()
                                }
                            }
                        )
                    }
                ){
                    AppContent(navController)
                }
            }
        }
    }
}

