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
    buildFeatures {
        compose = true
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

    // Compose
    implementation(Dependencies.Compose.maps)
    // Play Service
    implementation(Dependencies.playServiceMaps)
    // Retrofit
    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.moshi)
    // Hilt
    implementationsHilt()
    // Test
    testImplementation(Dependencies.Test.jUnit)
    androidTestImplementation(Dependencies.Test.jUnitAndroid)
    androidTestImplementation(Dependencies.Test.espressoCore)
    // Permission
    implementation(Dependencies.accompanistPermissions)
    // Live Data Compose
    implementation(Dependencies.Compose.liveData)
    // Coil
    implementation(Dependencies.coil)
    // Ui
    implementation(project(Module.Core.ui))
    // Common
    implementation(project(Module.Core.common))
    // Navigation
    implementation(project(Module.Core.navigation))
    //
    debugImplementation("androidx.customview:customview:1.1.0")
    debugImplementation("androidx.customview:customview-poolingcontainer:1.0.0-rc01")
}