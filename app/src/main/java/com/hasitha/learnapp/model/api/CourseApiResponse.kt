package com.hasitha.learnapp.model.api

import com.google.gson.annotations.SerializedName
import com.hasitha.learnapp.model.entities.Course
import com.hasitha.learnapp.model.entities.Topic

data class CourseApiResponse(

    val id: String?,
    val name: String?,

    @SerializedName("courses")
    val courses: List<Course>?

//    @SerializedName("topics")
//    val topics: List<Topic>?
)

// API Response
//data class CourseApiResponse(
//    @SerializedName("id")
//    val id: String?,
//
//    @SerializedName("name")
//    val name: String?,
//
//    @SerializedName("questions")
//    val questions: List<QuestionApiResponse>?
//)
//
//data class QuestionApiResponse(
//    @SerializedName("id")
//    val id: Int,
//
//    @SerializedName("name")
//    val name: String,
//
//    @SerializedName("topics")
//    val topics: List<Topic>?
//)