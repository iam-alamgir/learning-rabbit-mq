package com.divergent.rmq.consumer1.dto

data class OrderStatus(
    val order: Order? = null,
    val status: String = "",
    val message: String = ""
)
