package com.divergent.rmq.consumer2.dto

import com.divergent.rmq.consumer2.dto.Order

data class OrderStatus(
    val order: Order? = null,
    val status: String = "",
    val message: String = ""
)
