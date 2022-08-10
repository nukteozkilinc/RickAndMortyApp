package com.nukte.composefirst.presentation.detail

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nukte.composefirst.data.CharacterDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val characterDataSource: CharacterDataSource,
    private val savedStateHandle: SavedStateHandle
) : ViewModel(){
    private val _detailsState = mutableStateOf(DetailViewState())
    val detailsState = _detailsState
    val characterId = savedStateHandle.get<String>("charId")

    fun getCharacterbyId(charId: Int) = viewModelScope.launch {


    }
}