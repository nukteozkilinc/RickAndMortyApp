package com.nukte.composefirst.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nukte.composefirst.model.Characters

@Database(
    entities = [Characters::class],
    version = 1,
    exportSchema = false
    )
abstract class CharacterDb : RoomDatabase() {
    abstract fun charDao() : CharacterDao
}