package com.nukte.composefirst.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Entity(tableName = "characterTable")
@Serializable
data class Characters(

    @PrimaryKey var id: Int,
    @ColumnInfo(name = "name") var name: String? = null,
    @ColumnInfo(name = "status") var status: String? = null,
    var species: String? = null,
    var type: String? = null,
    var gender: String? = null,
    var origin: Origin? = Origin(),
    var location: Location? = Location(),
    var image: String? = null,
    var episode: ArrayList<String> = arrayListOf(),
    var url: String? = null,
    var created: String? = null,
    @ColumnInfo(name = "isSaved") var isSaved: Boolean

)