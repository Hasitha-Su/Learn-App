package com.hasitha.learnapp.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import retrofit2.Retrofit
import javax.inject.Singleton
import dagger.Provides
import dagger.hilt.InstallIn
import com.hasitha.learnapp.data.local.CourseDao
import com.hasitha.learnapp.data.local.LessonDao
import com.hasitha.learnapp.data.local.TopicDao
import com.hasitha.learnapp.data.remote.ApiService
import com.hasitha.learnapp.data.local.AppDatabase
import dagger.hilt.components.SingletonComponent
import retrofit2.converter.gson.GsonConverterFactory
import com.hasitha.learnapp.repository.CourseRepository
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java, "MyDB"
        ).build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.jsonkeeper.com/b/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideCourseDao(database: AppDatabase): CourseDao {
        return database.courseDao()
    }

    @Provides
    @Singleton
    fun provideTopicDao(database: AppDatabase): TopicDao {
        return database.topicDao()
    }

    @Provides
    @Singleton
    fun provideLessonDao(database: AppDatabase): LessonDao {
        return database.lessonDao()
    }

    @Provides
    @Singleton
    fun provideCourseRepository(
        apiService: ApiService,
        courseDao: CourseDao,
        topicDao: TopicDao,
        lessonDao: LessonDao,
    ): CourseRepository {
        return CourseRepository(apiService, courseDao, topicDao, lessonDao)
    }
}