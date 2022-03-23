package com.divergent.rmq.consumer3.listener

import com.divergent.rmq.consumer3.config.RMQConfig
import com.divergent.rmq.consumer3.dto.OrderStatus
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class RMQListener {
    @RabbitListener(queues = [RMQConfig.queueName])
    fun listener(orderStatus: OrderStatus) {
        println(orderStatus.toString())
    }
}
