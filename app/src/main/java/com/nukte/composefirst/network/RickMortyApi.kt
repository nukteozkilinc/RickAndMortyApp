package com.nukte.composefirst.network

import com.nukte.composefirst.model.Response
import retrofit2.http.GET

interface RickMortyApi {
    @GET("character")
    suspend fun getCharacters() : Response


}