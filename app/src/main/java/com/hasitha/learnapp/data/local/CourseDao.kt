package com.hasitha.learnapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hasitha.learnapp.model.entities.Course

/**
 * Data Access Object for interacting with the Room database.
 *
 * This interface includes methods for inserting, deleting, and querying courses.
 */
@Dao
interface CourseDao {
    @Query("SELECT * FROM courses")
    fun getAllCoursesLiveData(): LiveData<List<Course>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(course: Course)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(courses: List<Course>)
}