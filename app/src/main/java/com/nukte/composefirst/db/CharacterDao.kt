package com.nukte.composefirst.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nukte.composefirst.model.Characters

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(characters: Characters)

    @Query("SELECT * FROM characterTable")
    fun getAllChars() : List<Characters>

    @Query ("DELETE FROM characterTable WHERE id==:id")
    suspend fun deleteChars(id : Int)

    @Query ("SELECT EXISTS(SELECT * FROM characterTable WHERE id ==:id)")
    suspend fun isSavedBefore(id:Int) : Boolean
}