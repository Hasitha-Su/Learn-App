package com.hasitha.learnapp.model.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "topics",
    foreignKeys = [ForeignKey(entity = Course::class, parentColumns = ["id"], childColumns = ["courseId"], onDelete = ForeignKey.CASCADE)],
    indices = [Index(value = ["courseId"])]
)
data class Topic(
    @PrimaryKey
    val id: Int,
    val courseId: Int,
    val title: String
)
