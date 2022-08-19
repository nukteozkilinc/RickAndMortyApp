package com.nukte.composefirst.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nukte.composefirst.data.CharacterDataSource
import com.nukte.composefirst.model.Characters
import com.nukte.composefirst.repository.CharRepository
import com.nukte.composefirst.repository.CharRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val charRepository: CharRepository,
    private val characterDataSource: CharacterDataSource
) : ViewModel() {
    private val charStateFlow = MutableStateFlow(HomeViewState()) //data set edebilirsin
    val characterListFlow: StateFlow<HomeViewState> = charStateFlow

    init {
        getAllCharacter()
    }

    private fun getAllCharacter() = viewModelScope.launch {
        val characters = characterDataSource.getAllCharacters()
        charStateFlow.update { it.copy(characterList = characters) }
    }

    fun saveChar(char: Characters) = viewModelScope.launch {
        if (char.isSaved) {
            char.isSaved = false
            charRepository.unsaveChar(char.id)
            println("${char.isSaved}")
        } else {
            char.isSaved = true
            charRepository.saveChar(char)
            println("${char.isSaved}")
        }
    }
}