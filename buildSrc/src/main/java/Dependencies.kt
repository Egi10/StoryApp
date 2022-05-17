object Dependencies {
    object AndroidX {
        val coreKtx by lazy { "androidx.core:core-ktx:${Versions.AndroidX.coreKtx}" }
        val lifecycleRuntimeKtx by lazy {
            "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.AndroidX.lifecycleRuntimeKtx}"
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

    object Test {
        val jUnit by lazy { "junit:junit:${Versions.Test.jUnit}" }
        val jUnitAndroid by lazy { "androidx.test.ext:junit:${Versions.Test.jUnitAndroid}" }
        val espressoCore by lazy { "androidx.test.espresso:espresso-core:${Versions.Test.espressoCore}" }
    }
}