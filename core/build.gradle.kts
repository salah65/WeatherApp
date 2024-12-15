plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.hilt.android) version libs.versions.hiltAndroid
    kotlin("kapt")
}

android {
    namespace = "com.example.core"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildFeatures {
        buildConfig = true
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
}

dependencies {

    api(libs.androidx.runtime.android)
    api(libs.hilt.navigation.compose)
    api(libs.kotlinx.coroutines)
    api(libs.hilt.android)
    api(libs.okhttp.logging)
    api(libs.okhttp)
    api(libs.retrofit.converter.gson)
    api(libs.retrofit)
    kapt(libs.hilt.compiler)

    api(libs.coil.compose)
    api(libs.material)
    api(libs.androidx.appcompat)
    api(libs.androidx.core.ktx)
    api(libs.androidx.lifecycle.runtime.ktx)
    api(libs.androidx.activity.compose)
    api(platform(libs.androidx.compose.bom))
    api(libs.androidx.ui)
    api(libs.androidx.ui.graphics)
    api(libs.androidx.ui.tooling.preview)
    api(libs.androidx.material3)
}