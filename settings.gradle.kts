pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "StoryApp"
include(":app")
include(":libraries:network")
include(":libraries:data-store")
include(":features:authentication")
include(":core:common")
include(":core:ui")
include(":core:navigation")
