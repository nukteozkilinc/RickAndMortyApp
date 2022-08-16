package com.nukte.composefirst.repository

import com.nukte.composefirst.db.CharacterDao
import com.nukte.composefirst.di.IoDispatcher
import com.nukte.composefirst.model.Characters
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject


class CharRepositoryImpl @Inject constructor(
    private val characterDao: CharacterDao,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
) : CharRepository {
    override suspend fun saveChar(characters: Characters) {
        characterDao.insert(characters)
    }


     override suspend fun getAllChars(): List<Characters> = withContext(dispatcher){
         return@withContext characterDao.getAllChars()
     }

    override suspend fun deleteChars(_id: Int) {
        characterDao.deleteChars(_id)
    }

}