package com.example.mscustomer.api

import com.example.mscustomer.dto.ResponseServiceDto
import com.example.mscustomer.dto.TokenClientCredentialsDto
import com.example.mscustomer.service.AccountService
import com.example.mscustomer.service.CurrencyService
import com.example.mscustomer.service.KeycloakService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequestMapping("/customers")
class CustomerController @Autowired constructor (
    private val accountService: AccountService,
    private val keycloakService: KeycloakService,
    private val currencyService: CurrencyService
){

    @Value("7070")
    lateinit var port: String

    @GetMapping("/test")
    fun test(): String {
        accountService.test()
        return "Customer server port: $port"
    }

    @GetMapping("/list")
    fun getCustomers() = listOf("John", "Jane", "Jack") + accountService.getAccounts()

    @GetMapping("/currency/{name}")
    fun getCurrency(@PathVariable name: String): TokenClientCredentialsDto {
        if (!name.contains(name)) {
            throw Exception("Currency not found")
        }
        val token = keycloakService.token(mapOf(
            "grant_type" to "client_credentials",
            "client_id" to "backend",
            "client_secret" to "sJfdWcUkRXjnGHvkkRZ6q5ejibUEcPY7"))
        print(token.accessToken)
        return token
    }

    @GetMapping("/exchange")
    fun exchangeRate(@RequestParam to: String,
                     @RequestParam from: String,
                     @RequestParam amount: BigDecimal
    ): ResponseServiceDto {
        val result = currencyService.exchangeRate(to, from, amount)
        return result
    }

    @GetMapping("/list/exchanges")
    fun listExchanges(): List<String> {
        val result = currencyService.listCurrencies()
        return result
    }
}