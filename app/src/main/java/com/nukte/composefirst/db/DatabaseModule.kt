package com.nukte.composefirst.db

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import javax.inject.Singleton

@ExperimentalSerializationApi
@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideCharDao(characterDb: CharacterDb) : CharacterDao{
        return characterDb.charDao()
    }

    @Provides
    @Singleton
    fun provideCharacterDatabase(
      @ApplicationContext appContext : Context
    ) : CharacterDb{
        return Room.databaseBuilder(
            appContext,
            CharacterDb::class.java,
            "character_table"
        ).fallbackToDestructiveMigration().build()
    }

}