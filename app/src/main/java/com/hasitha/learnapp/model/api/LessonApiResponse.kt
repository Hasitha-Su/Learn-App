package com.hasitha.learnapp.model.api

data class LessonApiResponse (
    val id: Int,
    val topicId: Int?,
    val title: String,
    val content: String,
)
