package com.hasitha.learnapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hasitha.learnapp.model.api.CourseApiResponse
import com.hasitha.learnapp.model.entities.Course
import com.hasitha.learnapp.repository.CourseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    courseRepository: CourseRepository

) : ViewModel() {

//    init {
//        viewModelScope.launch {
//            CourseRepository.refreshCourses()
//        }
//    }

    val courses: LiveData<List<Course>> = courseRepository.courses
}
