package com.example.mscustomer.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.math.BigDecimal

@JsonIgnoreProperties(ignoreUnknown = true)
data class ResponseServiceDto (
    val success: Boolean,
    val query: RequestServiceDto,
    val data: String,
    val result: BigDecimal
)