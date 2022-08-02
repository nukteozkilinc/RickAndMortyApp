package com.nukte.composefirst.data

import androidx.lifecycle.LiveData
import com.nukte.composefirst.model.Characters
import com.nukte.composefirst.network.RickMortyApi
import javax.inject.Inject

class CharacterDataSourceImpl @Inject constructor(
    private val api : RickMortyApi
) : CharacterDataSource{
    override suspend fun getAllCharacters(): List<Characters> {
        val charList = api.getCharacters().character

        return charList
    }

}