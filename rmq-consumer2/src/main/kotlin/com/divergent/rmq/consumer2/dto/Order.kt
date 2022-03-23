package com.divergent.rmq.consumer2.dto

import java.util.UUID

data class Order(
    var id: String? = UUID.randomUUID().toString(),
    var name: String = "",
    var quantity: Int = 0,
    var price: Double = 0.0
)
