package com.nukte.composefirst.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nukte.composefirst.data.CharacterDataSource
import com.nukte.composefirst.model.Characters
import com.nukte.composefirst.repository.CharRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val characterDataSource: CharacterDataSource,
    private val charRepository: CharRepositoryImpl
) : ViewModel() {
    private val charStateFlow = MutableStateFlow(HomeViewState()) //data set edebilirsin
    val characterListFlow : StateFlow<HomeViewState> = charStateFlow


    init {
        getAllCharacter()
    }

    fun getAllCharacter() = viewModelScope.launch {
       val characters = characterDataSource.getAllCharacters()
        charStateFlow.update { it.copy(characterList = characters) }
    }

    fun saveChar(char: Characters) = viewModelScope.launch {
        char.isSaved = true
        charRepository.saveChar(char)
    }
}