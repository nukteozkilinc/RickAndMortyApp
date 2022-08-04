package com.nukte.composefirst.presentation.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.room.util.TableInfo

@Composable
fun DetailScreen(navController: NavController, backStackEntry: NavBackStackEntry) {
    val charId = backStackEntry.arguments?.getInt("charId") ?: -1
    val viewModel: DetailViewModel = hiltViewModel()
    viewModel.getCharacterbyId(charId)
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Hello $charId")
    }
}