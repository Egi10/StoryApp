import extensions.implementation
import extensions.implementationCoroutines
import extensions.implementationCompose
import extensions.implementationsHilt

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
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
}

dependencies {

    implementation(Dependencies.AndroidX.coreKtx)
    implementation(Dependencies.AndroidX.appCompat)
    implementation(Dependencies.AndroidX.material)
    testImplementation(Dependencies.Test.jUnit)
    androidTestImplementation(Dependencies.Test.jUnitAndroid)
    androidTestImplementation(Dependencies.Test.espressoCore)
    // ViewModel
    implementation(Dependencies.AndroidX.viewModel)
    // Hilt Navigation
    implementation(Dependencies.Hilt.navigation)
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
}

kapt {
    correctErrorTypes = true
}