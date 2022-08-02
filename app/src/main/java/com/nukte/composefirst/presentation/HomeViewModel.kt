package com.nukte.composefirst.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nukte.composefirst.data.CharacterDataSource
import com.nukte.composefirst.data.CharacterDataSourceImpl
import com.nukte.composefirst.model.Characters
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dataSourceImpl: CharacterDataSource
) : ViewModel() {
    private val charStateFlow = MutableStateFlow<List<Characters>>(listOf()) //data set edebilirsin
    val characterListFlow : StateFlow<List<Characters>> = charStateFlow
    init {
        getAllCharacter()
    }
    fun getAllCharacter() = viewModelScope.launch {
        charStateFlow.value = dataSourceImpl.getAllCharacters()
    }


}