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
        val input = "0001data"
        val output = tcpClient.sendData(input)
        println(output)
        return output
    }

    @RequestMapping("/bye")
    fun foo2(): String{
        return tcpClient.sendData("0002data")
    }

//    @RequestMapping("/pub")
//    fun foo3(): String{
//        return tcpClient.sendData("00120003data".toByteArray(charset("MS949")))
//    }
}