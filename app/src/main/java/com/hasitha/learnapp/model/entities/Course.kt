package com.hasitha.learnapp.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "courses")
data class Course(
    @PrimaryKey
    val id: Int,
    val name: String
)