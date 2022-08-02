package com.nukte.composefirst.data

import androidx.lifecycle.LiveData
import com.nukte.composefirst.model.Characters

interface CharacterDataSource {
    suspend fun getAllCharacters() : List<Characters>
}