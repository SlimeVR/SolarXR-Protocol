plugins {
    kotlin("jvm")
    application
}

repositories {
    mavenCentral()
}

val generatedTestSourcesDir = layout.buildDirectory.dir("generated/test-schemas")

kotlin {
    jvmToolchain(25)
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_25
    }
    sourceSets {
        test {
            kotlin.srcDir(generatedTestSourcesDir)
        }
    }
}

application {
    mainClass = "dev.slimevr.fbscodegen.MainKt"
}

tasks.named<JavaExec>("run") {
    dependsOn(tasks.named("classes"))
    workingDir = projectDir.parentFile
}

val generateTestSchemas by tasks.registering(JavaExec::class) {
    dependsOn(tasks.named("classes"))
    group = "verification"
    description = "Generates Kotlin fixtures from test FlatBuffers schemas."
    classpath = sourceSets.main.get().runtimeClasspath
    mainClass = application.mainClass
    workingDir = projectDir
    outputs.dir(generatedTestSourcesDir)
    val outputDir = generatedTestSourcesDir.get().asFile
    doFirst {
        outputDir.deleteRecursively()
    }
    args(
        "-o",
        generatedTestSourcesDir.get().asFile.absolutePath,
        "-I",
        projectDir.resolve("src/test/resources/schemas").absolutePath,
        projectDir.resolve("src/test/resources/schemas/all.fbs").absolutePath,
    )
}

tasks.named("compileTestKotlin") {
    dependsOn(generateTestSchemas)
}

tasks.test {
    useJUnitPlatform()
}

dependencies {
    implementation("com.squareup:kotlinpoet:2.2.0")
    val generatedProjectPath = sequenceOf(":solarxr-protocol:generated", ":generated")
        .firstOrNull { rootProject.findProject(it) != null }
        ?: error("Cannot find the generated SolarXR protocol project")

    testImplementation(project(generatedProjectPath))
    testImplementation(gradleTestKit())
    testImplementation("com.google.flatbuffers:flatbuffers-java:22.10.26")
    testImplementation(kotlin("test"))
}
