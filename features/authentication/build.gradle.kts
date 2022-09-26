import extensions.implementation
import extensions.implementationCoroutines
import extensions.implementationsHilt
import extensions.ksp

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("com.google.devtools.ksp") version "1.7.0-1.0.6"
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

    libraryVariants.all {
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
    implementation(Dependencies.AndroidX.appCompat)
    implementation(Dependencies.AndroidX.material)
    testImplementation(Dependencies.Test.jUnit)
    androidTestImplementation(Dependencies.Test.jUnitAndroid)
    androidTestImplementation(Dependencies.Test.espressoCore)
    // Coroutine
    implementationCoroutines()
    // Hilt
    implementationsHilt()
    // Network
    implementation(project(Module.network))
    // DataStore
    implementation(project(Module.dataStore))
    // Common
    implementation(project(Module.Core.common))
    // Ui
    implementation(project(Module.Core.ui))
    // Navigation
    implementation(project(Module.Core.navigation))
    // Compose Destination
    implementation(Dependencies.ComposeDestination.core)
    ksp(Dependencies.ComposeDestination.ksp)
}

kapt {
    correctErrorTypes = true
}