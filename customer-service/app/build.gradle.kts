import com.moowork.gradle.node.yarn.YarnTask
import com.moowork.gradle.node.yarn.YarnInstallTask

plugins {
    base
    id("com.moowork.node") version "1.3.1"
}

node {
    version = "12.4.0"
    download = true
}
//
//task bundle(type: NpmTask, dependsOn: npmInstall) {
//    args = ['run', 'build']
//}
//
//assemble.dependsOn(bundle

 val bundle by tasks.registering(YarnTask::class) {
     dependsOn(YarnInstallTask.NAME)
     args = listOf("run", "build")
}

val assemble by tasks.existing {
    dependsOn(bundle)
}
