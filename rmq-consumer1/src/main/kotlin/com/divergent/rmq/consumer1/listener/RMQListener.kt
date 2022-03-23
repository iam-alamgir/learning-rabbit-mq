package com.divergent.rmq.consumer1.listener

import com.divergent.rmq.consumer1.config.RMQConfig
import com.divergent.rmq.consumer1.dto.OrderStatus
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class RMQListener {
    @RabbitListener(queues = [RMQConfig.queueName])
    fun listener(orderStatus: OrderStatus) {
        println(orderStatus.toString())
    }
}
