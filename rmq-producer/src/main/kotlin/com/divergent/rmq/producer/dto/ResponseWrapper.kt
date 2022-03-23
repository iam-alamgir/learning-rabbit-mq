package com.divergent.rmq.producer.dto

data class ResponseWrapper<T>(
    val data: T,
    val message: String
)