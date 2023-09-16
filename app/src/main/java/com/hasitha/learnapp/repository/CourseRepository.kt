package com.hasitha.learnapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.hasitha.learnapp.data.remote.ApiService
import com.hasitha.learnapp.data.local.CourseDao
import com.hasitha.learnapp.data.local.LessonDao
import com.hasitha.learnapp.data.local.TopicDao
import com.hasitha.learnapp.model.entities.Course
import com.hasitha.learnapp.model.entities.Lesson
import com.hasitha.learnapp.model.entities.Topic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Repository for fetching and caching courses, topics, and lessons.
 *
 * This class communicates with both the remote API and local Room database.
 * It is responsible for caching the fetched data for offline usage.
 *
 */
class CourseRepository(
    private val apiService: ApiService,
    private val courseDao: CourseDao,
    private val topicDao: TopicDao,
    private val lessonDao: LessonDao,
) {

    val courses: LiveData<List<Course>> = courseDao.getAllCoursesLiveData()

    // Fetch data from the API and initialize the database
    suspend fun initializeDatabase() = withContext(Dispatchers.IO) {
        val response = apiService.getCourses() // Assuming this returns a QuizData

        Log.d("+++ response :  ", response.toString())
        response.courses?.toString()?.let { Log.d("+++ courses :  ", it) }

        var course: Course? =  null
        var coursesArr: List<Topic>

        if (response.id != null && response.name != null) {
            course = Course(response.id, response.name)
        }

        if (response.courses != null){
            coursesArr = response.courses as List<Topic>
        }


        if (course != null) {
            courseDao.insert(course)
        }

//        val topics = mutableListOf<Topic>()
//        val lessons = mutableListOf<Lesson>()

/*
        for (course in  response.courses) {

                if (course.topics != null) {
                    topicDao.insertAll(topics)
                    topics.addAll(course.topics)
                    for (topic in course.topics) {
                        //
                        if (topic.lessons != null) {
                            lessons.addAll(topic.lessons)
                        }
                    }
                }
            }

            //Insert the topics and lessons into their respective tables
            topicDao.insertAll(topics)
            lessonDao.insertAll(lessons)
        } else {
            // Handle error
            // Log or throw an exception
        }

 */
    }
}
