package com.nukte.composefirst.presentation.more

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nukte.composefirst.data.CharacterDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoreViewModel @Inject constructor(
    private val characterDataSource: CharacterDataSource,
    private val savedStateHandle: SavedStateHandle
) : ViewModel(){
    var state by mutableStateOf(
        MoreViewState.State(
            null
        )
    )

    init {
        viewModelScope.launch {
            val characterId = savedStateHandle.get<Int>("charId")
                ?:throw IllegalStateException("No charIs was passed to destination")
            val character = characterDataSource.getAllCharacters()
            val char = character.first{it.id == characterId}
            state = state.copy(char)
        }
    }

}