package com.nukte.composefirst.presentation.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nukte.composefirst.db.CharacterDao
import com.nukte.composefirst.model.Characters
import com.nukte.composefirst.repository.CharRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val charRepository: CharRepository
) : ViewModel() {
    private val charStateFlow = MutableStateFlow(FavoriteViewState()) //data set edebilirsin
    val characterListFlow: StateFlow<FavoriteViewState> = charStateFlow

    init {
        getSavedCharacters()
    }

    fun getSavedCharacters() = viewModelScope.launch {
        val characters = charRepository.getAllChars().filter { it.isSaved }
        charStateFlow.update { it.copy(characters) }
    }


    fun deleteChar(char: Characters) = viewModelScope.launch {
        char.isSaved = false
        charRepository.unsaveChar(char.id)
        getSavedCharacters()
    }

}