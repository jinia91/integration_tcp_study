package com.integration_client.integration_study_client.tcp

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MockController(
    private val tcpClient: TcpClient
) {

    @RequestMapping("/")
    fun foo(): String{
        return tcpClient.sendData("data".toByteArray()).toString()
    }
}