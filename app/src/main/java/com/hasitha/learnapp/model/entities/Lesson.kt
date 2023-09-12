package com.hasitha.learnapp.model.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "lessons",
    foreignKeys = [ForeignKey(entity = Topic::class, parentColumns = ["id"], childColumns = ["topicId"], onDelete = ForeignKey.CASCADE)]
)
data class Lesson(
    @PrimaryKey
    val id: Int,
    val topicId: Int,
    val title: String,
    val content: String
)
