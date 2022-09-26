import extensions.implementation
import extensions.ksp

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("com.google.devtools.ksp") version "1.7.0-1.0.6"
}

android {
    compileSdk = ConfigData.compileSdk

    defaultConfig {
        applicationId = "id.buaja.storyapp"
        minSdk = ConfigData.minSdk
        targetSdk = ConfigData.targetSdk
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    
    applicationVariants.all {
        kotlin.sourceSets {
            getByName(name) {
                kotlin.srcDir("build/generated/ksp/$name/kotlin")
            }
        }
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compose.composeCompiler
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Dependencies.AndroidX.coreKtx)
    implementation(Dependencies.AndroidX.lifecycleRuntimeKtx)
    testImplementation(Dependencies.Test.jUnit)
    androidTestImplementation(Dependencies.Test.jUnitAndroid)
    androidTestImplementation(Dependencies.Test.espressoCore)
    // Hilt
    implementation(Dependencies.Hilt.android)
    kapt(Dependencies.Hilt.compiler)
    // ViewModel
    implementation(Dependencies.AndroidX.viewModel)
    // Compose Destination
    implementation(Dependencies.ComposeDestination.core)
    ksp(Dependencies.ComposeDestination.ksp)
    // Network
    implementation(project(Module.network))
    // Ui
    implementation(project(Module.Core.ui))
    // Navigation
    implementation(project(Module.Core.navigation))
    // Authentication
    implementation(project(Module.Features.authentication))
    // Data Store
    implementation(project(Module.dataStore))
    // Home
    implementation(project(Module.Features.home))
    // Splash
    implementation(project(Module.Features.splash))
}

kapt {
    correctErrorTypes = true
}