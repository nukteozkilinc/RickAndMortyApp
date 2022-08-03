package com.nukte.composefirst.data

import com.nukte.composefirst.di.IoDispatcher
import com.nukte.composefirst.model.Characters
import com.nukte.composefirst.network.RickMortyApi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterDataSourceImpl @Inject constructor(
    private val api: RickMortyApi,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
) : CharacterDataSource {
    override suspend fun getAllCharacters(): List<Characters> = withContext(dispatcher) {
        return@withContext api.getCharacters().results
    }

}