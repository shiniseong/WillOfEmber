plugins {
    kotlin("jvm")
}


dependencies {
    testImplementation(libs.kotest)
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}