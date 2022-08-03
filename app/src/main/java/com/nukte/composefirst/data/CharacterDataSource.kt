package com.nukte.composefirst.data

import com.nukte.composefirst.model.Characters

interface CharacterDataSource {
    suspend fun getAllCharacters() : List<Characters>
}