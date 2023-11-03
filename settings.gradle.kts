enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven {
            setUrl("https://androidx.dev/storage/compose-compiler/repository/")
        }
    }
}

rootProject.name = "KmmStarWars"
include(":androidApp")
include(":shared")