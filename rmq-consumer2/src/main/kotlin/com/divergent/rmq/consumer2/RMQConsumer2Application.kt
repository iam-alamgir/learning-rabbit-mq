package com.divergent.rmq.consumer2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RMQConsumer1Application

fun main(args: Array<String>) {
    runApplication<RMQConsumer1Application>(*args)
}
