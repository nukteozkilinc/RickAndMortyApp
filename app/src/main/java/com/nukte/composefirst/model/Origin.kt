package com.nukte.composefirst.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Origin (

  @SerializedName("name" ) var name : String? = null,
  @SerializedName("url"  ) var url  : String? = null

)