package com.integration_client.integration_study_client.tcp

import org.springframework.integration.annotation.Gateway
import org.springframework.integration.annotation.MessagingGateway

@MessagingGateway(name = "tcpClient", defaultRequestChannel = "outbound")
interface TcpClient {
    @Gateway
    fun sendData(byteArray: ByteArray): ByteArray
}