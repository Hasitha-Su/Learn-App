package com.hasitha.learnapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hasitha.learnapp.model.api.CourseApiResponse
import com.hasitha.learnapp.model.entities.Course
import com.hasitha.learnapp.model.entities.Quiz

@Dao
    interface CourseDao {
        @Query("SELECT * FROM courses")
        fun getAllCoursesLiveData(): LiveData<Quiz>

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insert(course: Course)

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertAll(courses: List<Course>)

}
