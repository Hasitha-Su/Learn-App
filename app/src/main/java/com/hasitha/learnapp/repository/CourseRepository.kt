package com.hasitha.learnapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.hasitha.learnapp.data.remote.ApiService
import com.hasitha.learnapp.data.local.CourseDao
import com.hasitha.learnapp.data.local.LessonDao
import com.hasitha.learnapp.data.local.TopicDao
import com.hasitha.learnapp.model.api.CourseApiResponse
import com.hasitha.learnapp.model.entities.Course

class CourseRepository(
    private val apiService: ApiService,
    private val courseDao: CourseDao,
    private val topicDao: TopicDao,
    private val lessonDao: LessonDao
) {

    val courses: LiveData<List<Course>> = courseDao.getAllCoursesLiveData()

    suspend fun refreshCourses() {
        val response = apiService.getCourses()
        courseDao.insertAll2(response)
    }

//    suspend fun refreshData() {
//        val response = apiService.getCourses()
//        if(response != null) {
//        }
//    }


    // Function to refresh courses from the API
//    suspend fun refreshCourses() {
//        val apiResponse = apiService.getCourses()

        // Assume the API response is mapped to your local data entities
        //courseDao.insertAll(apiResponse.mapToCourses())  // You'll need to implement mapToCourses
        //topicDao.insertAll(apiResponse.mapToTopics())  // You'll need to implement mapToTopics
        //lessonDao.insertAll(apiResponse.mapToLessons())  // You'll need to implement mapToLessons
//    }
}