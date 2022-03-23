package com.divergent.rmq.producer.config

import org.springframework.amqp.core.AmqpTemplate
import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RMQConfig {
    companion object {
        const val queueName: String = "orders"
        const val exchangeName: String = "dvg-exchange"
        const val routingKey: String = "dvg-order-key"
    }

    @Bean
    fun queue(): Queue = Queue(queueName)

    @Bean
    fun exchange(): TopicExchange = TopicExchange(exchangeName)

    @Bean
    fun binding(queue: Queue, exchange: TopicExchange): Binding =
        BindingBuilder.bind(queue)
            .to(exchange)
            .with(routingKey)

    @Bean
    fun converter(): MessageConverter =
        Jackson2JsonMessageConverter()

    @Bean
    fun template(connectionFactory: ConnectionFactory): AmqpTemplate {
        val template = RabbitTemplate(connectionFactory)
        template.messageConverter = converter()
        return template
    }
}
