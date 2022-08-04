package com.nukte.composefirst.network

import com.nukte.composefirst.model.Characters
import com.nukte.composefirst.model.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RickMortyApi {
    @GET("character")
    suspend fun getCharacters() : Response

}