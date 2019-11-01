package taotao.httpbe

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.Mono

@SpringBootApplication
class HttpBeApplication

fun main(args: Array<String>) {
    runApplication<HttpBeApplication>(*args)
}

@Component
class Handler {
    fun get(req: ServerRequest): Mono<ServerResponse> {
        val res = "this is http"
        return ServerResponse.ok().body(Mono.just(res), String::class.java)
    }
}

@Configuration
class Router(val h: Handler) {
    @Bean
    fun apiRouter() = router {
        GET("/get", h::get)
    }
}