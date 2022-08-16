package com.nukte.composefirst.db

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.nukte.composefirst.model.Location


class RoomLocationTypeConverter {

    @TypeConverter
    fun stringToLocation(location: String): Location {
        return Gson().fromJson(location, Location::class.java)
    }

    @TypeConverter
    fun locationToString(location: Location): String {
        return Gson().toJson(location)
    }
}