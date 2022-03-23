package com.divergent.rmq.consumer3.dto

import com.divergent.rmq.consumer3.dto.Order

data class OrderStatus(
    val order: Order? = null,
    val status: String = "",
    val message: String = ""
)
