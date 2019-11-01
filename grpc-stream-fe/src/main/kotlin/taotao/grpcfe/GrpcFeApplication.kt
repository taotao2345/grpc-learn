package taotao.grpcfe

import io.grpc.ManagedChannelBuilder
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyToServerSentEvents
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono
import taotao.grpc.GreeterGrpc
import taotao.grpc.Message
import java.time.Duration

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
    val PORT: Int = 6568

    fun stream(req: ServerRequest): Mono<ServerResponse> {
        if (stub == null) {
            val channel = ManagedChannelBuilder.forAddress(HOST, PORT).usePlaintext(true).build()
            stub = GreeterGrpc.newBlockingStub(channel);
        }

        val msg = Message.newBuilder().setText("hello").build()
        val replies = stub!!.list(msg)

        val st = Flux.interval(Duration.ofSeconds(1))
                .flatMap {
                    if (replies.hasNext()) {
                        replies.next().message.toString().toMono()
                    } else {
                        Mono.empty()
                    }
                }

        return ServerResponse.ok().bodyToServerSentEvents(st)
    }
}

@Configuration
class Router(val h: Handler) {
    @Bean
    fun apiRouter() = router {
        GET("/stream", h::stream)
    }
}