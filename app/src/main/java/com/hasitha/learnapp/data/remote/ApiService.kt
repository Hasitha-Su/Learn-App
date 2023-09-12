package com.hasitha.learnapp.data.remote

import com.hasitha.learnapp.model.api.CourseApiResponse
import com.hasitha.learnapp.model.entities.Quiz
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("L5OQ")
    suspend fun getCourses(): Response<Quiz>
}
