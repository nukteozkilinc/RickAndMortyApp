package com.nukte.composefirst.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel


@ExperimentalFoundationApi
@Composable
fun HomeScreen(
    viewModel : HomeViewModel = hiltViewModel(),
){
    val viewState by viewModel.characterListFlow.collectAsState()

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 300.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ){
        items(viewState.characterList){
            CharList.Content(character = it )
        }
    }
}