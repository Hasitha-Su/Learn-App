package com.hasitha.learnapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.hasitha.learnapp.model.entities.Course
import com.hasitha.learnapp.model.entities.Quiz
import com.hasitha.learnapp.model.entities.Topic
import com.hasitha.learnapp.model.entities.Lesson

@Dao
interface QuizDao {

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertQuiz(quiz: Quiz)

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertCourses(courses: List<Course>)

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertTopics(topics: List<Topic>)

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertLessons(lessons: List<Lesson>)

}


