package com.nukte.composefirst.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel


@ExperimentalFoundationApi
@Composable
fun HomeScreen(viewModel : HomeViewModel = hiltViewModel()){

    val character by viewModel.characterListFlow.collectAsState()

    if(character.isNotEmpty()){
        LazyVerticalGrid( //Recyclerview
            cells = GridCells.Adaptive(160.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ){
            items(items = character, itemContent = { CharList.Content(it) })
        }
    }
}



