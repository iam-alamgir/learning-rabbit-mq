package com.divergent.rmq.consumer3

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RMQConsumer3Application

fun main(args: Array<String>) {
    runApplication<RMQConsumer3Application>(*args)
}
