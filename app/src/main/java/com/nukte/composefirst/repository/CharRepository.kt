package com.nukte.composefirst.repository

import androidx.lifecycle.LiveData
import com.nukte.composefirst.model.Characters

interface CharRepository {
    suspend fun saveChar(characters: Characters)
    suspend fun getAllChars() : List<Characters>
    suspend fun deleteChars(_id : Int)
}