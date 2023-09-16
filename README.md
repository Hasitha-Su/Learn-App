# Learn-App
LearnApp is a comprehensive educational platform designed to provide a seamless learning experience.

## About

LearnApp is an Android application built to provide a smooth learning experience. The application displays courses, topics, and lessons from an external API and stores them in a local database for offline usage. The project is based on the MVVM architecture and utilizes technologies such as Kotlin, Retrofit, Room, Dagger Hilt, and Coroutines.

## Features

- Fetches courses, topics, and lessons from an external API
- Caches data locally using Room for offline use
- Implements MVVM architecture
- Utilizes Kotlin Coroutines for asynchronous operations
- Dependency Injection using Dagger Hilt

## Setup

1. **Clone the Repository**

2. **Navigate to the project directory and build the project**
    ```bash
    cd LearnApp
    ./gradlew build
    ```

3. **Run the app on an Android Emulator or physical device.**

## Dependencies

- Retrofit - For making network requests
- Room - For local data persistence
- Dagger Hilt - For dependency injection
- Kotlin Coroutines - For managing background threads
- LiveData - For data-binding

## Future Improvements

- Pagination for API calls to improve performance.
- Implement unit tests for robustness.
- Add user authentication for personalized experience.
- Search functionality for courses, topics, and lessons.
