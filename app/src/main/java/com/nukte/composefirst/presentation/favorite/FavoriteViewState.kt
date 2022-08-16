package com.nukte.composefirst.presentation.favorite

import com.nukte.composefirst.model.Characters

data class FavoriteViewState (
    val characterList : List<Characters> = listOf()
        )