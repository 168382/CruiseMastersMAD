// app/build.gradle.kts
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.cruisemastersmad"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.cruisemastersmad"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
        // Or if using Compose:
        // compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    // Networking
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    // Image Loading
    implementation(libs.glide)
    // Or for Compose: implementation(libs.coil.compose)
    dependencies {
        // ... existing dependencies

        // RecyclerView
        implementation("androidx.recyclerview:recyclerview:1.3.2")

        // CardView
        implementation("androidx.cardview:cardview:1.0.0")

        // Material Design
        implementation("com.google.android.material:material:1.10.0")

        // Retrofit for API calls
        implementation("com.squareup.retrofit2:retrofit:2.9.0")
        implementation("com.squareup.retrofit2:converter-gson:2.9.0")

        // Glide for image loading
        implementation("com.github.bumptech.glide:glide:4.16.0")

        testImplementation(libs.junit)
        androidTestImplementation(libs.androidx.junit)
        androidTestImplementation(libs.androidx.espresso.core)
    }
}