package com.hasitha.learnapp.model.api

import com.google.gson.annotations.SerializedName

data class TopicApiResponse(
    val id: Int,
    val courseId: Int,
    val title: String,

    @SerializedName("lessons")
    val courses: List<LessonApiResponse>?
)

