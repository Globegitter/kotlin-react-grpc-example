import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    id("com.google.protobuf") version "0.8.9"
    kotlin("jvm") version "1.3.40"
}

application {
    mainClassName = "MainKt"
}

group = "com.github.marcoferrer.krotoplus"
version = "1.0-SNAPSHOT"

val coroutinesVersion: String by project
val grpcVersion: String by project
val krotoplusVersion: String by project
val protobufVersion: String by project

allprojects {
    repositories {
        mavenCentral()
        if(krotoplusVersion.endsWith("SNAPSHOT")){
            maven("https://oss.jfrog.org/artifactory/oss-snapshot-local")
        }
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")

    implementation("io.grpc:grpc-protobuf:$grpcVersion")
    implementation("io.grpc:grpc-stub:$grpcVersion")
    implementation("io.grpc:grpc-netty:$grpcVersion")

    implementation("com.github.marcoferrer.krotoplus:kroto-plus-coroutines:$krotoplusVersion")
    implementation("com.google.protobuf:protobuf-java:$protobufVersion")

    implementation(project(":api"))
    implementation(project(":app"))
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
        kotlinOptions.freeCompilerArgs += listOf("-Xuse-experimental=kotlinx.coroutines.ObsoleteCoroutinesApi")
    }
}
