package com.nukte.composefirst.presentation.home

import com.nukte.composefirst.model.Characters

data class HomeViewState(
    val characterList : List<Characters> = listOf(),
)
