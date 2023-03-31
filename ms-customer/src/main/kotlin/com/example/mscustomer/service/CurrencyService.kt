package com.example.mscustomer.service

import com.example.mscustomer.dto.ResponseServiceDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import java.math.BigDecimal

@FeignClient(name = "currency-converter")
interface CurrencyService {

    @GetMapping("/api/currency/exchange")
    fun exchangeRate(@RequestParam to: String,
                     @RequestParam from: String,
                     @RequestParam amount: BigDecimal
    ): ResponseServiceDto

    @GetMapping("/api/currency/list")
    fun listCurrencies(): List<String>

}