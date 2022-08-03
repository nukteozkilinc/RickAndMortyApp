package com.nukte.composefirst.presentation

import com.nukte.composefirst.model.Characters

data class HomeViewState(
    val characterList : List<Characters> = listOf()
)
