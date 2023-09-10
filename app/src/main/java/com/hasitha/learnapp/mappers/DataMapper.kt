package com.hasitha.learnapp.mappers

import com.hasitha.learnapp.model.api.CourseApiResponse
import com.hasitha.learnapp.model.entities.Course
import com.hasitha.learnapp.model.entities.Lesson
import com.hasitha.learnapp.model.entities.Topic

object DataMappers {
/*
    fun apiResponseToCourse(courseApiResponse: CourseApiResponse?): Course? {

        return courseApiResponse?.let {
            Course(
                id = it.id ?: 1,  // You may want to handle this more gracefully
                name = it.name ?: ""
            )
        }
    }

    fun apiResponseToTopics(courseApiResponse: CourseApiResponse?): List<Topic> {

        return courseApiResponse?.topics?.map { apiTopic ->
            Topic(
                id = apiTopic.id,
                courseId = apiTopic.courseId,
                title = apiTopic.title
            )
        } ?: emptyList()
    }

    fun apiResponseToLessons(courseApiResponse: CourseApiResponse?): List<Lesson> {

        val lessons = mutableListOf<Lesson>()

        courseApiResponse?.questions?.forEach { apiTopic ->
            apiTopic?.forEach { apiLesson ->
                lessons.add(
                    Lesson(
                        id = apiLesson.id,
                        topicId = apiTopic.id,
                        title = apiLesson.title,
                        content = apiTopic.content
                    )
                )
            }
        }

        courseApiResponse?.


        return lessons
    }

 */
}
