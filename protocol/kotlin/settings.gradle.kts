rootProject.name = "solarxr-protocol"

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
    plugins {
        kotlin("jvm") version "2.3.10"
    }
}

include(":codegen")
project(":codegen").projectDir = File("codegen")