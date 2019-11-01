package taotao.httpfe

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.Mono
import java.net.URI

@SpringBootApplication
class HttpFeApplication {
    @Bean
    fun restTemplate(): RestTemplate {
        return RestTemplate()
    }
}

fun main(args: Array<String>) {
    runApplication<HttpFeApplication>(*args)
}

@Component
class Handler {
    @Autowired
    lateinit var restTemplate: RestTemplate

    val URL: String = "http://localhost:8082"

    fun get(req: ServerRequest): Mono<ServerResponse> {
        val uri = URI.create("$URL/get")
        val res = restTemplate.getForObject(uri, String::class.java)
        return ServerResponse.ok().body(Mono.just(res.toString()), String::class.java)
    }
}

@Configuration
class Router(val h: Handler) {
    @Bean
    fun apiRouter() = router {
        GET("/get", h::get)
    }
}