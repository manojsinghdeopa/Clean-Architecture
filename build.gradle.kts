// Top-level build.gradle.kts

plugins {
    id("com.android.application") version "8.12.1" apply false
    id("com.android.library") version "8.12.1" apply false
    id("org.jetbrains.kotlin.android") version "2.0.0" apply false
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.0" apply false
    id("com.google.dagger.hilt.android") version "2.48" apply false
    id("org.jlleitschuh.gradle.ktlint") version "11.6.0" apply false // optional code style plugin
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
