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

    override fun list(request: Message?, responseObserver: StreamObserver<Reply>?) {
        while (true) {
            println(System.currentTimeMillis() / 1000)
            val reply = Reply.newBuilder()
                    .setMessage("this is stream message... " + System.currentTimeMillis() / 1000)
                    .build()

            responseObserver?.onNext(reply)
            Thread.sleep(3000)
        }
    }
}