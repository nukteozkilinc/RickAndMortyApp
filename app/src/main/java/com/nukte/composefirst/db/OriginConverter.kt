package com.nukte.composefirst.db

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.nukte.composefirst.model.Origin


class RoomOriginTypeConverter {

    @TypeConverter
    fun stringToOrigin(origin: String): Origin {
        return Gson().fromJson(origin, Origin::class.java)
    }

    @TypeConverter
    fun originToString(origin: Origin): String {
        return Gson().toJson(origin)
    }
}