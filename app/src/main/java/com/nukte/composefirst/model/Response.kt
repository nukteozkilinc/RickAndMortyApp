package com.nukte.composefirst.model

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("info"    ) var info    : Info?              = Info(),
    @SerializedName("results" ) var results : ArrayList<Characters> = arrayListOf()
)
