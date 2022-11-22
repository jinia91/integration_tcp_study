package com.integration_client.integration_study_client.was.infra.http

import com.integration_client.integration_study_client.application.TcpClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MockController(
    private val tcpClient: TcpClient
) {

    @RequestMapping("/hello")
    fun foo(): String{
        return tcpClient.sendData("00120001data")
    }

    @RequestMapping("/bye")
    fun foo2(): String{
        return tcpClient.sendData("00120002data")
    }
}