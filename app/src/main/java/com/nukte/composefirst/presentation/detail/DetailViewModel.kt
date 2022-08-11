package com.nukte.composefirst.presentation.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nukte.composefirst.data.CharacterDataSource
import com.nukte.composefirst.model.Characters
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val characterDataSource: CharacterDataSource,
    private val savedStateHandle: SavedStateHandle
) : ViewModel(){
    /*private val _detailsState = mutableStateOf(DetailViewState())
    val detailsState = _detailsState*/
    var state by mutableStateOf(
        DetailViewState.State(
            null
        )
    )
    //val characterId = savedStateHandle.get<Int>("charId")

    init {
        viewModelScope.launch {
            val characterId = savedStateHandle.get<Int>("charId")
                ?: throw IllegalStateException("No charIs was passed to destination")
            val character = characterDataSource.getAllCharacters()
            val char = character.first{it.id == characterId}
            state = state.copy(char)


        }
    }

    /*fun getCharacterbyId(charId: Int) = viewModelScope.launch {

    }*/
    /*fun getCharacterbyId(charId: Int)  = viewModelScope.launch{
        val char = characterDataSource.getAllCharacters()[charId]
        detailsState.apply { state.characterDetail = char }
    }*/
}