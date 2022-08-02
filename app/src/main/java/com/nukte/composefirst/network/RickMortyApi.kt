package com.nukte.composefirst.network

import com.nukte.composefirst.model.Characters
import com.nukte.composefirst.model.Results
import retrofit2.http.GET

interface RickMortyApi {

    companion object{
        const val BASE_URL ="https://rickandmortyapi.com/api/"
    }

    @GET("character")
    suspend fun getCharacters() : Results
}