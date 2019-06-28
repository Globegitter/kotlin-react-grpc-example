import com.google.protobuf.gradle.*
//import groovy.lang.Closure
//import org.gradle.api.NamedDomainObjectContainer
//import org.gradle.kotlin.dsl.NamedDomainObjectContainerScope
//import org.gradle.kotlin.dsl.closureOf

val coroutinesVersion: String by project
val grpcVersion: String by project
val krotoplusVersion: String by project
val protobufVersion: String by project



apply(plugin = "kotlin")
apply(plugin = "com.google.protobuf")
apply(plugin = "idea")

plugins {
    application
    kotlin("jvm")
    id("com.google.protobuf")
}

application {
    mainClassName = "MainKt"
}


dependencies {

    // For jdk 9+ you need to include javax.annotations
    // The reason is outlined in this grpc issue
    // https://github.com/grpc/grpc-java/issues/4725
    compileOnly("javax.annotation:javax.annotation-api:1.2")

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("com.github.marcoferrer.krotoplus:kroto-plus-coroutines:$krotoplusVersion")

    implementation("com.google.protobuf:protobuf-java:$protobufVersion")
    implementation("io.grpc:grpc-protobuf:$grpcVersion")
    implementation("io.grpc:grpc-stub:$grpcVersion")
    implementation("io.grpc:grpc-netty:$grpcVersion")
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:$protobufVersion"
    }

    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:$grpcVersion"
        }
        id("coroutines") {
            artifact = "com.github.marcoferrer.krotoplus:protoc-gen-grpc-coroutines:$krotoplusVersion:jvm8@jar"
        }
        id("grpc-web") {
            path = "/usr/local/bin/protoc-gen-grpc-web"
        }
    }

    generateProtoTasks {

        all().forEach {
            it.builtins {
                named("java") {
                    option("lite")
                }
                id("js") {
                    option("import_style=commonjs")
                }
            }
            it.plugins {
                id("grpc") {
                    option("lite")
                }
                id("coroutines")
                id("grpc-web") {
                    option("import_style=typescript")
                    option("mode=grpcwebtext")
                }
            }
        }
    }
}
