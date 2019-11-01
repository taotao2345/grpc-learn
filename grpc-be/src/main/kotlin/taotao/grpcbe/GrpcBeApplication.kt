package taotao.grpcbe

import io.grpc.stub.StreamObserver
import org.lognet.springboot.grpc.GRpcService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import taotao.grpc.GreeterGrpc
import taotao.grpc.Message
import taotao.grpc.Reply

@SpringBootApplication
class GrpcBeApplication

fun main(args: Array<String>) {
    runApplication<GrpcBeApplication>(*args)
}

@GRpcService
class Service : GreeterGrpc.GreeterImplBase() {

    override fun get(request: Message?, responseObserver: StreamObserver<Reply>?) {
        val reply = Reply.newBuilder().setMessage("this is reply...").build()
        responseObserver?.onNext(reply)
        responseObserver?.onCompleted()
    }
}