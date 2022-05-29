import extensions.implementationsHilt

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
}

android {
    compileSdk = ConfigData.compileSdk

    defaultConfig {
        minSdk = ConfigData.minSdk
        targetSdk = ConfigData.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compose.compose
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    // Hilt
    implementationsHilt()
    // Paging
    implementation(Dependencies.AndroidX.paging)
    implementation(Dependencies.Compose.paging)
    // Coil
    implementation(Dependencies.coil)
    // Ui
    implementation(project(Module.Core.ui))
    // Navigation
    implementation(project(Module.Core.navigation))
    // Data Store
    implementation(project(Module.dataStore))
    // Network
    implementation(project(Module.network))
    // Story
    implementation(project(Module.Features.story))
}

kapt {
    correctErrorTypes = true
}