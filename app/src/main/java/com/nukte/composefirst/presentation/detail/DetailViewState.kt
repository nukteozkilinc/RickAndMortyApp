package com.nukte.composefirst.presentation.detail

import com.nukte.composefirst.model.Characters

/*data class DetailViewState (
    var characterDetail : Characters?=null
)*/

class DetailViewState{
    data class State(
        val characterDetail : Characters?
    )
}