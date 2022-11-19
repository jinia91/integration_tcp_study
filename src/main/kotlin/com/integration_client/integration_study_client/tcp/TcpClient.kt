package com.integration_client.integration_study_client.tcp

import org.springframework.integration.annotation.Gateway
import org.springframework.integration.annotation.MessagingGateway
import org.springframework.stereotype.Component

@MessagingGateway(defaultRequestChannel = "input")
@Component
interface TcpClient {
    @Gateway
    fun sendData(byteArray: ByteArray): String
}