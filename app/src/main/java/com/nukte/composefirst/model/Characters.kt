package com.nukte.composefirst.model

import kotlinx.serialization.Serializable

@Serializable
data class Characters(
    var id : Int,
    var name : String,
    var status : String,
    var species : String,
    var gender : String,
    var image : Int
): java.io.Serializable