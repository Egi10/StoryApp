package extensions

import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.implementationCoroutines() {
    implementation(Dependencies.Coroutine.core)
    implementation(Dependencies.Coroutine.android)
    testImplementation(Dependencies.Coroutine.test)
}

fun DependencyHandler.implementationsHilt() {
    implementation(Dependencies.Hilt.android)
    kapt(Dependencies.Hilt.compiler)

    // For instrumentation tests
    androidTestImplementation(Dependencies.Hilt.androidTesting)
    kaptAndroidTest(Dependencies.Hilt.compiler)

    // For local unit tests
    testImplementation(Dependencies.Hilt.androidTesting)
    kaptTest(Dependencies.Hilt.compiler)
}

fun DependencyHandler.implementationCompose() {
    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.material)
    implementation(Dependencies.Compose.uiToolingPreview)
    implementation(Dependencies.Compose.activityCompose)
    androidTestImplementation(Dependencies.Compose.uiTestJunit4)
    debugImplementation(Dependencies.Compose.uiTooling)
    debugImplementation(Dependencies.Compose.uiTestManifest)
}

fun DependencyHandler.implementation(dependencyNotation: String) {
    add("implementation", dependencyNotation)
}

fun DependencyHandler.kapt(dependencyNotation: String) {
    add("kapt", dependencyNotation)
}

fun DependencyHandler.testImplementation(dependencyNotation: String) {
    add("testImplementation", dependencyNotation)
}

fun DependencyHandler.kaptTest(dependencyNotation: String) {
    add("kaptTest", dependencyNotation)
}

fun DependencyHandler.androidTestImplementation(dependencyNotation: String) {
    add("androidTestImplementation", dependencyNotation)
}

fun DependencyHandler.kaptAndroidTest(dependencyNotation: String) {
    add("kaptAndroidTest", dependencyNotation)
}

fun DependencyHandler.debugImplementation(dependencyNotation: String) {
    add("debugImplementation", dependencyNotation)
}

/**
 * To use ksp make sure you have added the ksp plugin
 * @link 'https://kotlinlang.org/docs/ksp-quickstart.html#pass-options-to-processors'
 */
fun DependencyHandler.ksp(dependencyNotation: String) {
    add("ksp", dependencyNotation)
}