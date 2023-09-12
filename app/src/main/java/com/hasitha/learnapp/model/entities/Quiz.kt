package com.hasitha.learnapp.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.hasitha.learnapp.model.CourseTypeConverter

@Entity(tableName = "quizzes")
data class Quiz(
    @PrimaryKey
    val id: String,
    val name: String,
    // Assuming we serialize "courses" in type converter
    @TypeConverters(CourseTypeConverter::class)
    val courses: List<Course>
)
