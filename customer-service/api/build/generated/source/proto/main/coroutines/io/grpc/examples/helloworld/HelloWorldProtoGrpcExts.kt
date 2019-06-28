package io.grpc.examples.helloworld

import kotlin.Unit
import kotlin.jvm.JvmName
import kotlinx.coroutines.channels.SendChannel

@JvmName("sendHelloRequest")
suspend inline fun SendChannel<HelloRequest>.send(block: HelloRequest.Builder.() -> Unit) {
    val request = HelloRequest.newBuilder().apply(block).build()
    send(request)
}
