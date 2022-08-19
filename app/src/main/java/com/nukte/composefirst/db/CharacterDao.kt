package com.nukte.composefirst.db

import androidx.room.*
import com.nukte.composefirst.model.Characters

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(characters: Characters)

    @Query("SELECT * FROM characterTable")
    fun getAllCharacters() : List<Characters>

    @Query("DELETE FROM characterTable where id ==:id")
    suspend fun deleteCharacters(id:Int)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(characters: Characters)

    @Update
    suspend fun updateCharacters(characters: List<Characters>)

    /*@Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(characters: Characters): Int

    @Query("SELECT * FROM characterTable")
    fun getAllChars(): List<Characters>

    @Query("DELETE FROM characterTable WHERE id==:id")
    suspend fun deleteChars(id: Int)

    //@Insert(onConflict = OnConflictStrategy.REPLACE)
    @Update
    suspend fun updateCharacters(characters: List<Characters>)*/

}