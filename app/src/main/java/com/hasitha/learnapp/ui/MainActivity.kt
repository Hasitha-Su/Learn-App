package com.hasitha.learnapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hasitha.learnapp.R
import com.hasitha.learnapp.repository.CourseRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Main Activity of the LearnApp.
 *
 * This activity is the entry point of the application. It sets up the navigation
 * and is responsible for managing the lifecycle of the app.
 *
 * @property viewModel The ViewModel associated with this activity for MVVM architecture.
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    @Inject
    lateinit var courseRepository: CourseRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            CoroutineScope(Dispatchers.IO).launch {
                courseRepository.initializeDatabase()
            }

        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // Initialize the TextView
        val courseTextView: TextView = findViewById(R.id.courseTextView)

        viewModel.courses.observe(this, Observer { courseList ->
            // Update UI
            if (courseList != null) {
                courseTextView.text = courseList.toString()
            } else {
                courseTextView.text = "It's null"
            }
        })
    }
}