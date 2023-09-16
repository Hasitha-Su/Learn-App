package com.hasitha.learnapp.data.remote

import com.hasitha.learnapp.model.api.GetCourseApiResponse
import retrofit2.http.GET

interface ApiService {
    @GET("BBI9")
    suspend fun getCourses():GetCourseApiResponse
}
