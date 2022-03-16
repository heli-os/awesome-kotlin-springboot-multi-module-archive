package awesome.kotlin.springboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @Author Heli
 */
@SpringBootApplication
class SpringBootApplication

fun main(args: Array<String>) {
    runApplication<awesome.kotlin.springboot.SpringBootApplication>(*args)
}

@RestController
class HelloRestController {

    @RequestMapping(
        value = ["/hello"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun hello() = "Hello, application"
}
