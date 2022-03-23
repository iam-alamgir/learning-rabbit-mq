package com.divergent.rmq.producer.dto

import java.util.UUID

data class Order(
    var id: String? = UUID.randomUUID().toString(),
    val name: String,
    val quantity: Int,
    val price: Double
)
