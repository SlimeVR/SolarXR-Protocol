plugins {
    kotlin("jvm")
    application
}

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(24)
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_24
    }
}

application {
    mainClass = "dev.slimevr.fbscodegen.MainKt"
}

tasks.named<JavaExec>("run") {
    // Run relative to protocol/kotlin/ so callers can use paths like ../../schema
    workingDir = rootProject.projectDir
}

dependencies {
    implementation("com.squareup:kotlinpoet:2.2.0")
}