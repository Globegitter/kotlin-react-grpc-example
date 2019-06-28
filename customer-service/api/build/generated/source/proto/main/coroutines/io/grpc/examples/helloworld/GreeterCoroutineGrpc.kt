// THIS IS AN AUTOGENERATED FILE. DO NOT EDIT THIS FILE DIRECTLY.
package io.grpc.examples.helloworld

import com.github.marcoferrer.krotoplus.coroutines.StubDefinition
import com.github.marcoferrer.krotoplus.coroutines.client.ClientBidiCallChannel
import com.github.marcoferrer.krotoplus.coroutines.client.ClientStreamingCallChannel
import com.github.marcoferrer.krotoplus.coroutines.client.clientCallBidiStreaming
import com.github.marcoferrer.krotoplus.coroutines.client.clientCallClientStreaming
import com.github.marcoferrer.krotoplus.coroutines.client.clientCallServerStreaming
import com.github.marcoferrer.krotoplus.coroutines.client.clientCallUnary
import com.github.marcoferrer.krotoplus.coroutines.server.ServiceScope
import com.github.marcoferrer.krotoplus.coroutines.server.serverCallBidiStreaming
import com.github.marcoferrer.krotoplus.coroutines.server.serverCallClientStreaming
import com.github.marcoferrer.krotoplus.coroutines.server.serverCallServerStreaming
import com.github.marcoferrer.krotoplus.coroutines.server.serverCallUnary
import com.github.marcoferrer.krotoplus.coroutines.server.serverCallUnimplementedStream
import com.github.marcoferrer.krotoplus.coroutines.server.serverCallUnimplementedUnary
import com.github.marcoferrer.krotoplus.coroutines.withCoroutineContext
import io.grpc.BindableService
import io.grpc.CallOptions
import io.grpc.Channel
import io.grpc.MethodDescriptor
import io.grpc.ServerServiceDefinition
import io.grpc.stub.AbstractStub
import io.grpc.stub.StreamObserver
import io.grpc.stub.annotations.RpcMethod
import javax.annotation.Generated
import kotlin.String
import kotlin.Unit
import kotlin.jvm.JvmName
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel

@Generated(
        value = ["by Kroto+ Proto-c Grpc Coroutines Plugin (version 0.4.0)"],
        comments = "Source: helloworld.proto"
)
object GreeterCoroutineGrpc {
    const val SERVICE_NAME: String = GreeterGrpc.SERVICE_NAME

    fun newStub(channel: Channel): GreeterCoroutineStub = GreeterCoroutineStub.newStub(channel)
    suspend fun newStubWithContext(channel: Channel): GreeterCoroutineStub =
            GreeterCoroutineStub.newStubWithContext(channel)
    class GreeterCoroutineStub private constructor(channel: Channel, callOptions: CallOptions =
            CallOptions.DEFAULT) : AbstractStub<GreeterCoroutineStub>(channel, callOptions) {
        override fun build(channel: Channel, callOptions: CallOptions): GreeterCoroutineStub =
                GreeterCoroutineStub(channel,callOptions)

        @RpcMethod(
                fullMethodName = "$SERVICE_NAME/SayHello",
                requestType = HelloRequest::class,
                responseType = HelloReply::class,
                methodType = MethodDescriptor.MethodType.UNARY
        )
        suspend fun sayHello(request: HelloRequest = HelloRequest.getDefaultInstance()): HelloReply
                = clientCallUnary(request, GreeterGrpc.getSayHelloMethod())

        @RpcMethod(
                fullMethodName = "$SERVICE_NAME/SayHelloStreaming",
                requestType = HelloRequest::class,
                responseType = HelloReply::class,
                methodType = MethodDescriptor.MethodType.BIDI_STREAMING
        )
        fun sayHelloStreaming(): ClientBidiCallChannel<HelloRequest, HelloReply> =
                clientCallBidiStreaming(GreeterGrpc.getSayHelloStreamingMethod())

        @RpcMethod(
                fullMethodName = "$SERVICE_NAME/SayHelloClientStreaming",
                requestType = HelloRequest::class,
                responseType = HelloReply::class,
                methodType = MethodDescriptor.MethodType.CLIENT_STREAMING
        )
        fun sayHelloClientStreaming(): ClientStreamingCallChannel<HelloRequest, HelloReply> =
                clientCallClientStreaming(GreeterGrpc.getSayHelloClientStreamingMethod())

        @RpcMethod(
                fullMethodName = "$SERVICE_NAME/SayHelloServerStreaming",
                requestType = HelloRequest::class,
                responseType = HelloReply::class,
                methodType = MethodDescriptor.MethodType.SERVER_STREAMING
        )
        fun sayHelloServerStreaming(request: HelloRequest = HelloRequest.getDefaultInstance()):
                ReceiveChannel<HelloReply> = clientCallServerStreaming(request,
                GreeterGrpc.getSayHelloServerStreamingMethod())

        suspend inline fun sayHello(block: HelloRequest.Builder.() -> Unit): HelloReply {
            val request = HelloRequest.newBuilder().apply(block).build()
            return sayHello(request)
        }

        inline fun sayHelloServerStreaming(block: HelloRequest.Builder.() -> Unit):
                ReceiveChannel<HelloReply> {
            val request = HelloRequest.newBuilder().apply(block).build()
            return sayHelloServerStreaming(request)
        }

        companion object : StubDefinition<GreeterCoroutineStub> {
            override val serviceName: String = GreeterGrpc.SERVICE_NAME

            override fun newStub(channel: Channel): GreeterCoroutineStub =
                    GreeterCoroutineStub(channel)
            override suspend fun newStubWithContext(channel: Channel): GreeterCoroutineStub =
                    GreeterCoroutineStub(channel).withCoroutineContext()}
    }

    abstract class GreeterImplBase : BindableService, ServiceScope {
        private val delegate: ServiceDelegate = ServiceDelegate()

        override fun bindService(): ServerServiceDefinition = delegate.bindService()
        open suspend fun sayHello(request: HelloRequest): HelloReply =
                serverCallUnimplementedUnary(GreeterGrpc.getSayHelloMethod())

        open suspend fun sayHelloStreaming(requestChannel: ReceiveChannel<HelloRequest>,
                responseChannel: SendChannel<HelloReply>) {
            serverCallUnimplementedStream(GreeterGrpc.getSayHelloStreamingMethod(),responseChannel)
        }

        open suspend fun sayHelloClientStreaming(requestChannel: ReceiveChannel<HelloRequest>):
                HelloReply =
                serverCallUnimplementedUnary(GreeterGrpc.getSayHelloClientStreamingMethod())

        open suspend fun sayHelloServerStreaming(request: HelloRequest, responseChannel:
                SendChannel<HelloReply>) {
            serverCallUnimplementedStream(GreeterGrpc.getSayHelloServerStreamingMethod(),responseChannel)
        }

        @JvmName("sendHelloReply")
        suspend inline fun SendChannel<HelloReply>.send(block: HelloReply.Builder.() -> Unit) {
            val response = HelloReply.newBuilder().apply(block).build()
            send(response)
        }

        private inner class ServiceDelegate : GreeterGrpc.GreeterImplBase() {
            override fun sayHello(request: HelloRequest, responseObserver:
                    StreamObserver<HelloReply>) {
                serverCallUnary(GreeterGrpc.getSayHelloMethod(),responseObserver) {
                    sayHello(request)
                }
            }

            override fun sayHelloStreaming(responseObserver: StreamObserver<HelloReply>):
                    StreamObserver<HelloRequest> {
                val requestChannel =
                        serverCallBidiStreaming(GreeterGrpc.getSayHelloStreamingMethod(),responseObserver)
                        { requestChannel: ReceiveChannel<HelloRequest>, responseChannel:
                        SendChannel<HelloReply> ->
                    sayHelloStreaming(requestChannel, responseChannel)
                }
                return requestChannel
            }

            override fun sayHelloClientStreaming(responseObserver: StreamObserver<HelloReply>):
                    StreamObserver<HelloRequest> {
                val requestObserver =
                        serverCallClientStreaming(GreeterGrpc.getSayHelloClientStreamingMethod(),responseObserver)
                        { requestChannel: ReceiveChannel<HelloRequest> ->
                    sayHelloClientStreaming(requestChannel)
                }
                return requestObserver
            }

            override fun sayHelloServerStreaming(request: HelloRequest, responseObserver:
                    StreamObserver<HelloReply>) {
                serverCallServerStreaming(GreeterGrpc.getSayHelloServerStreamingMethod(),responseObserver)
                        { responseChannel: SendChannel<HelloReply> ->
                    sayHelloServerStreaming(request, responseChannel)
                }
            }
        }
    }
}
