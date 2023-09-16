package com.hasitha.learnapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hasitha.learnapp.model.entities.Course
import com.hasitha.learnapp.model.entities.Lesson
import com.hasitha.learnapp.model.entities.Topic

@Database(entities = [Course::class, Topic::class, Lesson::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun courseDao(): CourseDao
    abstract fun topicDao(): TopicDao
    abstract fun lessonDao(): LessonDao
}
