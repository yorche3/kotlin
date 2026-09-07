plugins {
    kotlin("jvm") version "2.4.10"
}

group = "com.yorche3.programminglanguages"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("io.kotest:kotest-runner-junit5:6.2.4")
    testImplementation("io.kotest:kotest-assertions-core:6.2.4")
}

tasks.test {
    useJUnitPlatform()
}
