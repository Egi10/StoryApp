object Dependencies {
    object AndroidX {
        val coreKtx by lazy { "androidx.core:core-ktx:${Versions.AndroidX.coreKtx}" }
        val lifecycleRuntimeKtx by lazy {
            "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.AndroidX.lifecycleRuntimeKtx}"
        }
        val dataStorePreferences by lazy {
            "androidx.datastore:datastore-preferences:${Versions.AndroidX.dataStorePreferences}"
        }
        val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.AndroidX.appCompat}" }
        val material by lazy { "com.google.android.material:material:1.6.0" }
        val viewModel by lazy {
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.AndroidX.lifecycleRuntimeKtx}"
        }
    }

    object Compose {
        val ui by lazy { "androidx.compose.ui:ui:${Versions.Compose.compose}" }
        val material by lazy { "androidx.compose.material:material:${Versions.Compose.compose}" }
        val uiToolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview:${Versions.Compose.compose}" }
        val activityCompose by lazy {
            "androidx.activity:activity-compose:${Versions.Compose.activityCompose}"
        }

        /**
         * Test Compose
         */
        val uiTestJunit4 by lazy { "androidx.compose.ui:ui-test-junit4:${Versions.Compose.compose}" }

        /**
         * Debug
         */
        val uiTooling by lazy { "androidx.compose.ui:ui-tooling:${Versions.Compose.compose}" }
        val uiTestManifest by lazy { "androidx.compose.ui:ui-test-manifest:${Versions.Compose.compose}" }
    }

    object Hilt {
        val android by lazy { "com.google.dagger:hilt-android:${Versions.hilt}" }
        val compiler by lazy { "com.google.dagger:hilt-compiler:${Versions.hilt}" }

        /**
         * Instrument Test
         */
        val androidTesting by lazy { "com.google.dagger:hilt-android-testing:${Versions.hilt}" }

        val navigation by lazy { "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigation}" }

    }

    object Retrofit {
        val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
        val moshi by lazy { "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}" }
    }

    object Coroutine {
        val core by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}" }
        val android by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}" }
        val test by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutine}" }
    }

    object Test {
        val jUnit by lazy { "junit:junit:${Versions.Test.jUnit}" }
        val jUnitAndroid by lazy { "androidx.test.ext:junit:${Versions.Test.jUnitAndroid}" }
        val espressoCore by lazy { "androidx.test.espresso:espresso-core:${Versions.Test.espressoCore}" }
    }
}