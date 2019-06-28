import com.github.marcoferrer.krotoplus.coroutines.launchProducerJob
import com.github.marcoferrer.krotoplus.coroutines.withCoroutineContext
import customer_service.api.GreeterService
import io.grpc.ManagedChannelBuilder
import io.grpc.Server
import io.grpc.ServerBuilder
import io.grpc.examples.helloworld.GreeterCoroutineGrpc
import io.grpc.examples.helloworld.send
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.consumeEach

//val server: Server = InProcessServerBuilder
//    .forName("helloworld")
//    .addService(GreeterService())
//    .directExecutor()
//    .build()
//    .start()
//val serverBuilder = ServerBuilder<?>()
//
//val channel: Channel = InProcessChannelBuilder
//    .forName("helloworld")
//    .directExecutor()
//    .build()

fun main(){
    val greeterService = GreeterService()
    val port = 9090
    val server: Server = ServerBuilder.forPort(port).addService(greeterService).build()

    val channel = ManagedChannelBuilder.forAddress("localhost", port)
        .usePlaintext()
        .build()

    Runtime.getRuntime().addShutdownHook(Thread {
        println("Ups, JVM shutdown")
        server.shutdown()
        server.awaitTermination()

        println("Chat service stopped")
    })

    server.start()
    println("Chat service started on $port")

    GlobalScope.launch{
        val stub = GreeterCoroutineGrpc.newStub(channel).withCoroutineContext()

        performUnaryCall (stub)
    }

    server.awaitTermination()
}

suspend fun performUnaryCall(stub: GreeterCoroutineGrpc.GreeterCoroutineStub){

    val unaryResponse = stub.sayHello { name = "John" }

    println("Unary Response: ${unaryResponse.message}")
}

suspend fun performServerStreamingCall(stub: GreeterCoroutineGrpc.GreeterCoroutineStub){

    val responseChannel = stub.sayHelloServerStreaming { name = "John" }

    responseChannel.consumeEach {
        println("Server Streaming Response: ${it.message}")
    }
}

suspend fun performClientStreamingCall(stub: GreeterCoroutineGrpc.GreeterCoroutineStub) = coroutineScope{

    // Client Streaming RPC
    val (requestChannel, response) = stub.sayHelloClientStreaming()

    launchProducerJob(requestChannel){
        repeat(5){
            send { name = "person #$it" }
        }
    }

    println("Client Streaming Response: ${response.await().toString().trim()}")
}

suspend fun performBidiCall(stub: GreeterCoroutineGrpc.GreeterCoroutineStub) = coroutineScope {

    val (requestChannel, responseChannel) = stub.sayHelloStreaming()

    launchProducerJob(requestChannel){
        repeat(5){
            send { name = "person #$it" }
        }
    }

    responseChannel.consumeEach {
        println("Bidi Response: ${it.message}")
    }
}
