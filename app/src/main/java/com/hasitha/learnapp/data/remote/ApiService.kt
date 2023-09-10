package com.hasitha.learnapp.data.remote

import com.hasitha.learnapp.model.api.CourseApiResponse
import retrofit2.http.GET

interface ApiService {
    @GET("L5OQ")
    suspend fun getCourses(): CourseApiResponse
}
