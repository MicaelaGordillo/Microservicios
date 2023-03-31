package com.example.mscustomer.dto

import java.math.BigDecimal

data class RequestServiceDto (
    val from: String,
    val to: String,
    val amount: BigDecimal
)