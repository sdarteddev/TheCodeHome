plugins {
    kotlin("jvm") version "1.9.22"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    // Clikt makes building beautiful CLI interfaces in Kotlin incredibly easy
    implementation("com.github.ajalt.clikt:clikt-jvm:4.2.2")
    // kotlinx.serialization to format our "freeze" outputs cleanly
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")
}

application {
    mainClass.set("com.frostxmoves.AppKt")
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "com.frostxmoves.AppKt"
    }
    // Simplifies running it as a single fat JAR
    from({
        configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) }
    })
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}
