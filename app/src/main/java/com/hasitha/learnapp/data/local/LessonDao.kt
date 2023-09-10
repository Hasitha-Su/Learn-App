package com.hasitha.learnapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hasitha.learnapp.model.entities.Lesson

@Dao
interface LessonDao {
    @Query("SELECT * FROM lessons WHERE topicId = :topicId")
    fun getLessonsByTopic(topicId: Int): LiveData<List<Lesson>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(lesson: Lesson)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(lessons: List<Lesson>)
}
