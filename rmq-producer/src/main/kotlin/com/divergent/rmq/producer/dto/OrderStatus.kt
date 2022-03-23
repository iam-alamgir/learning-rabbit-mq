package com.divergent.rmq.producer.dto

data class OrderStatus(
    val order: Order,
    val status: String,
    val message: String
)
