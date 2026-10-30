rootProject.name = "solarxr-protocol-dev"

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
    plugins {
        kotlin("jvm") version "2.3.10"
        kotlin("multiplatform") version "2.3.10"
    }
}

include(":generated")
project(":generated").projectDir = file("protocol/kotlin")

include(":codegen")
project(":codegen").projectDir = file("kotlin-codegen")
