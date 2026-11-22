plugins {
    kotlin("jvm") version "2.4.10"
    application
}

application {
    mainClass.set("cl.viajes.MainKt")
}

group = "cl.viajes"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")
}

kotlin {
    jvmToolchain(25)
}

tasks.test {
    useJUnitPlatform()
}