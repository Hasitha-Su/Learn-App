package com.hasitha.learnapp.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hasitha.learnapp.model.entities.Course

object CourseTypeConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromString(value: String?): List<Course>? {
        val listType = object : TypeToken<List<Course>>() {}.type
        return gson.fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<Course>?): String? {
        return gson.toJson(list)
    }
}
