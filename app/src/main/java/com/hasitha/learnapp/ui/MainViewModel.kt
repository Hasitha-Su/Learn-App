package com.hasitha.learnapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hasitha.learnapp.model.entities.Course
import com.hasitha.learnapp.repository.CourseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * ViewModel for the Main Activity.
 *
 * This class is responsible for preparing and managing the data for the MainActivity.
 * It handles the API requests and updates the UI as required.
 *
 * @property CourseRepository The repository instance used for fetching data.
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    courseRepository: CourseRepository

) : ViewModel() {

    val courses: LiveData<List<Course>> = courseRepository.courses
}
