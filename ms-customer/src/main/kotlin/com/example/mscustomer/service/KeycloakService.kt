package com.example.mscustomer.service

import com.example.mscustomer.dto.TokenClientCredentialsDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping

@FeignClient(name = "keycloak", url = "http://localhost:8080/realms/software/protocol/openid-connect/token")
interface KeycloakService {

    @PostMapping(consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE])
    fun token(formParams: Map<String, *>): TokenClientCredentialsDto

}