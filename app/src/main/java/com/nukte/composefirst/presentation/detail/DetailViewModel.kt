package com.nukte.composefirst.presentation.detail

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nukte.composefirst.data.CharacterDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val characterDataSource: CharacterDataSource
) : ViewModel(){
    private val _detailsState = mutableStateOf(DetailViewState())
    val detailsState = _detailsState
    val characterId = mutableStateOf(0)

    fun getCharacterbyId(charId: Int) = viewModelScope.launch {


    }
}