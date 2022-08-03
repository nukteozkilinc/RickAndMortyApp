package com.nukte.composefirst.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel


@ExperimentalFoundationApi
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel : HomeViewModel = hiltViewModel(),
){
    val viewState by viewModel.characterListFlow.collectAsState()


    Column(modifier = Modifier.fillMaxSize()) {
        viewState.characterList.forEach {
            Text(text = it.name.orEmpty())
        }
    }

    /*character.let { items ->
        LazyVerticalGrid( //Recyclerview
            cells = GridCells.Adaptive(160.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ){
            items(items = items, itemContent = { CharList.Content(it) })
        }
    }*/
}