package com.nukte.composefirst.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nukte.composefirst.model.Characters

@Database(
    entities = [Characters::class],
    version = 1,
    exportSchema = false
    )
@TypeConverters(
    RoomOriginTypeConverter::class,
    RoomLocationTypeConverter::class,
    RoomArrayListTypeConverter::class
)
abstract class CharacterDb : RoomDatabase() {
    abstract fun charDao() : CharacterDao
}