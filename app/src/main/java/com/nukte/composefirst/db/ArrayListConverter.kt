package com.nukte.composefirst.db

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.nukte.composefirst.model.Location


class RoomArrayListTypeConverter {

    @TypeConverter
    fun stringToArrayList(arrayList: String): ArrayList<String> {
        return Gson().fromJson(arrayList, ArrayList<String>().javaClass)
    }

    @TypeConverter
    fun arrayListToString(string : ArrayList<String>): String {
        return Gson().toJson(string)
    }
}