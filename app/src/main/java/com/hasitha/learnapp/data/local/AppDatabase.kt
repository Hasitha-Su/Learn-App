package com.hasitha.learnapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.hasitha.learnapp.data.local.CourseDao
import com.hasitha.learnapp.data.local.LessonDao
import com.hasitha.learnapp.data.local.TopicDao
import com.hasitha.learnapp.data.remote.ApiService
import com.hasitha.learnapp.model.entities.Course
import com.hasitha.learnapp.model.entities.Lesson
import com.hasitha.learnapp.model.entities.Topic
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Course::class, Topic::class, Lesson::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun courseDao(): CourseDao
    abstract fun topicDao(): TopicDao
    abstract fun lessonDao(): LessonDao

    companion object {
        val CALLBACK = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                CoroutineScope(Dispatchers.IO).launch {
                    refreshData()
                }
            }
        }
    }

    private suspend fun refreshData() {

        val apiResponse = ApiService.getCourses()
    }
}
