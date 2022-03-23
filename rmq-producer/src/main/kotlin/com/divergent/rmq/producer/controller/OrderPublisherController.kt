package com.divergent.rmq.producer.controller

import com.divergent.rmq.producer.config.RMQConfig
import com.divergent.rmq.producer.dto.Order
import com.divergent.rmq.producer.dto.OrderStatus
import com.divergent.rmq.producer.dto.ResponseWrapper
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/order")
class OrderPublisherController {
    @Autowired
    private lateinit var template: RabbitTemplate

    @PostMapping("/{restaurantName}")
    fun placeOrder(
        @PathVariable restaurantName: String,
        @RequestBody order: Order
    ): ResponseWrapper<Order> {
        order.id = UUID.randomUUID().toString()

        val orderStatus = OrderStatus(
            order = order,
            status = "processing",
            message = "Order is being processed"
        )

        template.convertAndSend(
            RMQConfig.exchangeName,
            RMQConfig.routingKey,
            orderStatus
        )

        return ResponseWrapper(
            data = order,
            message = "Order is being processed at $restaurantName"
        )
    }
}