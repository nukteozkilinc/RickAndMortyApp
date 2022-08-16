package com.nukte.composefirst.presentation.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nukte.composefirst.model.Characters
import com.nukte.composefirst.repository.CharRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val charRepository: CharRepositoryImpl
) : ViewModel() {
    private val charStateFlow = MutableStateFlow(FavoriteViewState()) //data set edebilirsin
    val characterListFlow : StateFlow<FavoriteViewState> = charStateFlow

    init {
        getSavedCharacters()
    }

    fun getSavedCharacters() = viewModelScope.launch {
        val characters = charRepository.getAllChars()
        charStateFlow.update { it.copy(characterList = characters) }
    }
    fun saveChar(char: Characters) = viewModelScope.launch {
        char.isSaved = true
        charRepository.saveChar(char)
    }
    fun deleteChar(char: Characters) = viewModelScope.launch {
        char.isSaved = false
        char.id?.let { charRepository.deleteChars(it) }
    }

}