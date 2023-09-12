package com.hasitha.learnapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.hasitha.learnapp.data.remote.ApiService
import com.hasitha.learnapp.data.local.CourseDao
import com.hasitha.learnapp.data.local.LessonDao
import com.hasitha.learnapp.data.local.QuizDao
import com.hasitha.learnapp.data.local.TopicDao
import com.hasitha.learnapp.model.api.CourseApiResponse
import com.hasitha.learnapp.model.entities.Course
import com.hasitha.learnapp.model.entities.Lesson
import com.hasitha.learnapp.model.entities.Quiz
import com.hasitha.learnapp.model.entities.Topic

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CourseRepository(
    private val apiService: ApiService,
    private val courseDao: CourseDao,
    private val topicDao: TopicDao,
    private val lessonDao: LessonDao,
    private val quizDao: QuizDao
) {
    val courses: LiveData<Quiz> = courseDao.getAllCoursesLiveData()

    // Fetch data from the API and initialize the database

    suspend fun initializeDatabase() = withContext(Dispatchers.IO) {
        val response = apiService.getCourses() // Assuming this returns a QuizData
        if (response.isSuccessful && response.body() != null) {
            val quizData = response.body()!!

            // Insert Quizzes
            val quiz = Quiz(quizData.id, quizData.name, quizData.courses)
            quizDao.insertQuiz(quiz)  // Assuming quizDao exists and has an insert method

            // Insert Courses
            val courses = quizData.courses
            courseDao.insertAll(courses)

            // Declare lists to hold topics and lessons
            val topics = mutableListOf<Topic>()
            val lessons = mutableListOf<Lesson>()

            for (course in courses) {
                // This assumes that 'course.topics' is available from the API response.
                if (course.topics != null) {
                    topics.addAll(course.topics)
                    for (topic in course.topics) {
                        if (topic.lessons != null) {
                            lessons.addAll(topic.lessons)
                        }
                    }
                }
            }

            // Insert the topics and lessons into their respective tables
            topicDao.insertAll(topics)
            lessonDao.insertAll(lessons)
        } else {
            // Handle error
            // Log or throw an exception
        }
    }


    // Example: fetch courses from the local database
//    fun getCoursesFromDb(): LiveData<List<Course>> {
//        return courseDao.getAllCoursesLiveData()
//    }

    // Example: fetch a single course by its ID
//    suspend fun getCourseById(courseId: Int): Course? {
//        return courseDao.getCourseById(courseId)
//    }
}
