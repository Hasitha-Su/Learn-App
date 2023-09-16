package com.hasitha.learnapp.model.api

import com.google.gson.annotations.SerializedName

data class CourseApiResponse (
    val id: String?,
    val name: String?,

    @SerializedName("topics")
    val courses: List<TopicApiResponse>?

)