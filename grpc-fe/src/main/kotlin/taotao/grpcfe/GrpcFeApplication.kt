package taotao.grpcfe

import io.grpc.ManagedChannelBuilder
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.Mono
import taotao.grpc.GreeterGrpc
import taotao.grpc.Message

@SpringBootApplication
class GrpcFeApplication

fun main(args: Array<String>) {
    runApplication<GrpcFeApplication>(*args)
}

@Component
class Handler {
    companion object {
        var stub: GreeterGrpc.GreeterBlockingStub? = null
    }

    val HOST: String = "localhost"
    val PORT: Int = 6566

    fun get(req: ServerRequest): Mono<ServerResponse> {
        if (stub == null) {
            val channel = ManagedChannelBuilder.forAddress(HOST, PORT).usePlaintext(true).build()
            stub = GreeterGrpc.newBlockingStub(channel);
        }

        val msg = Message.newBuilder().setText("hello").build()
        return ServerResponse.ok().body(Mono.just(stub!!.get(msg).message.toString()), String::class.java)
    }
}

@Configuration
class Router(val h: Handler) {
    @Bean
    fun apiRouter() = router {
        GET("/get", h::get)
    }
}