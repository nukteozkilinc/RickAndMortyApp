package com.nukte.composefirst.repository

import com.nukte.composefirst.data.CharacterDataSource
import com.nukte.composefirst.db.CharacterDao
import com.nukte.composefirst.di.IoDispatcher
import com.nukte.composefirst.model.Characters
import it.czerwinski.android.hilt.annotations.Bound
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Bound
@Singleton
class CharRepositoryImpl @Inject constructor(
    private val characterDao: CharacterDao,
    private val charactersDataSource: CharacterDataSource,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
) : CharRepository {

    override suspend fun saveChar(characters: Characters) {
        characterDao.insert(characters)
    }

    override suspend fun getAllChars(): List<Characters> = withContext(dispatcher){
        val remoteCharacters = characterDao.getAllCharacters()
        characterDao.updateCharacters(remoteCharacters)

        return@withContext characterDao.getAllCharacters()
    }

    override suspend fun unsaveChar(_id: Int) {
        characterDao.deleteCharacters(_id)
    }
}