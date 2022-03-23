package com.divergent.rmq.producer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RMQProducerApplication

fun main(args: Array<String>) {
    runApplication<RMQProducerApplication>(*args)
}
