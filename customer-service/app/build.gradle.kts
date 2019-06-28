import com.google.protobuf.gradle.*

val coroutinesVersion: String by project
val grpcVersion: String by project
val krotoplusVersion: String by project
val protobufVersion: String by project

plugins {
//    application
    base
    idea
    id("com.moowork.node") version "1.3.1"
    kotlin("jvm")
    id("com.google.protobuf")
}

dependencies {
    protobuf(files("../api/src/main/proto"))
}

node {
    version = "12.4.0"
    download = true
}

//val generateProto by tasks.existing
val yarn_install by tasks.existing
//val generateProto by tasks.existing

val yarn_run_start by tasks.existing {
    dependsOn(yarn_install)
    dependsOn("generateProto")
}

val yarn_run_build by tasks.existing {
    dependsOn(yarn_install)
    dependsOn("generateProto")

    inputs.files(fileTree("src"))
    inputs.file("package.json")
    inputs.file("yarn.lock")
    inputs.file("tsconfig.json")

    // Ideally we would be more fine-grained here See https://github.com/facebook/create-react-app/issues/1354#issuecomment-428741120 for a workaround
    outputs.dir("build")
}

val assemble by tasks.existing {
    dependsOn(yarn_run_build)
}

val compileJava by tasks.existing {
    enabled = false
}

sourceSets{
    named("main") {
        java {
            srcDir("src")
        }
    }
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:$protobufVersion"
    }

    plugins {
        id("grpc-web") {
            path = "/usr/local/bin/protoc-gen-grpc-web"
        }
    }

    generateProtoTasks {

        all().forEach {
            it.builtins {
                remove("java")
                id("js") {
                    option("import_style=commonjs")
                    outputSubDir = "grpc-web"
                }
            }
            it.plugins {
                id("grpc-web") {
                    option("import_style=typescript")
                    option("mode=grpcwebtext")
                    outputSubDir = "grpc-web"
                }
            }
        }
    }
}
