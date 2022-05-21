import extensions.implementation
import extensions.implementationCoroutines
import extensions.implementationsHilt

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("com.google.devtools.ksp").version("1.6.10-1.0.4")
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

    implementation(Dependencies.AndroidX.coreKtx)
    implementation(Dependencies.AndroidX.appCompat)
    implementation(Dependencies.AndroidX.material)
    testImplementation(Dependencies.Test.jUnit)
    androidTestImplementation(Dependencies.Test.jUnitAndroid)
    androidTestImplementation(Dependencies.Test.espressoCore)
    // ViewModel
    implementation(Dependencies.AndroidX.viewModel)
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
    ksp("com.squareup.moshi:moshi-kotlin-codegen:1.13.0")
}

kapt {
    correctErrorTypes = true
}