package com.nukte.composefirst.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.nukte.composefirst.components.Logo


@ExperimentalFoundationApi
@Composable
fun HomeScreen(
    openUser: () -> Unit
){
    HomeScreen(
        viewModel =  hiltViewModel(),
        openUser = openUser
    )
}

@Composable
internal fun HomeScreen(
    viewModel : HomeViewModel,
    openUser: () -> Unit
){
    val viewState by viewModel.characterListFlow.collectAsState()

    Column (
        modifier = Modifier.fillMaxSize()
    ){
        Logo(
            modifier = Modifier.fillMaxWidth()
        )
        Content(character = viewState.characterList,openUser)
    }
}