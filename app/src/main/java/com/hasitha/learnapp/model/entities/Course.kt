package com.hasitha.learnapp.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Data Model for representing a Course.
 *
 * This class holds the attributes of a course and is used for local database storage.
 *
 * @property id Unique identifier of the course.
 * @property name Name of the course.
 */
@Entity(tableName = "courses")
data class Course(
    @PrimaryKey
    val id: String,
    val name: String
)