package com.example.msaccount.api

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@RestController
@RequestMapping("/accounts")
class AccountController {
    companion object {
        val LOGGER: Logger = LoggerFactory.getLogger(AccountController::class.java)
        val accounts = listOf("91232231", "538483", "1233212")
    }

    @Value("\${server.port}")
    lateinit var port: String

    @GetMapping("/test")
    fun test(): String {
        LOGGER.info("test")
        return "Account server port: $port"
    }

    @GetMapping("/list")
    fun getAccounts(): List<String> {
        LOGGER.info("getAccounts")
        return accounts
    }

    @GetMapping("/{id}")
    fun getAccount(@PathVariable id: Int): String {
        LOGGER.info("getAccount")
        return accounts[id]
    }
}