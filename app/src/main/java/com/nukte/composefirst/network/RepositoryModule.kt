package com.nukte.composefirst.network

import com.nukte.composefirst.data.CharacterDataSource
import com.nukte.composefirst.data.CharacterDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindNewsDataSource(newsDataSourceImpl: CharacterDataSourceImpl): CharacterDataSource
}