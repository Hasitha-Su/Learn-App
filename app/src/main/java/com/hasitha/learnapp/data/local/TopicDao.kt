package com.hasitha.learnapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hasitha.learnapp.model.entities.Topic

@Dao
interface TopicDao {
    @Query("SELECT * FROM topics WHERE courseId = :courseId")
    fun getTopicsByCourse(courseId: Int): LiveData<List<Topic>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(topic: Topic)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(topics: List<Topic>)
}