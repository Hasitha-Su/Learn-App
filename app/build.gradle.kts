plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id ("dagger.hilt.android.plugin")
}

android {
    namespace = "com.hasitha.learnapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.hasitha.learnapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }
    kotlinOptions {
        jvmTarget = "18"
    }
}

dependencies {

    implementation ("androidx.core:core-ktx:1.10.1")
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("com.google.android.material:material:1.9.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")

    val fragment_version = "1.6.1"
    val nav_version = "2.7.1"

    // Include the AndroidX Fragment library
    implementation("androidx.fragment:fragment-ktx:$fragment_version")

    // Fragment navigation support -Kotlin
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

    // Fragment navigation support - Feature module Support
    implementation("androidx.navigation:navigation-dynamic-features-fragment:$nav_version")

    // Fragment navigation support - Testing Navigation
    androidTestImplementation("androidx.navigation:navigation-testing:$nav_version")

    //Dagger - Hilt
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-android-compiler:2.44")

    //  ———  gson ——— ++
    implementation ("com.google.code.gson:gson:2.9.0")

    //  ———  retrofit ——— ++
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    //  ———  coroutines ——— ++
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")

    // lifecycle & ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")

    // Room
    val room_version = "2.5.2"

    implementation ("androidx.room:room-ktx:$room_version")
    implementation("androidx.room:room-runtime:$room_version")
    kapt("androidx.room:room-compiler:$room_version")

}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}