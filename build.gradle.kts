plugins {
    kotlin("jvm") version "1.9.21"
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.8.10")
    implementation("org.jetbrains.kotlinx:multik-core:0.2.2")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(18)
}