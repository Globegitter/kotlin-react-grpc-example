rootProject.name = "self-service-grpc--experiment"

//includeBuild("customer-service/api")
include(":api")
project(":api").projectDir = file("./customer-service/api")
include(":app")
project(":app").projectDir = file("./customer-service/app")