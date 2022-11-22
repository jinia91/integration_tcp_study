package com.integration_client.integration_study_client.application

import org.springframework.stereotype.Service

@Service
class TranferService(
    private val client: TcpClient
) {
    fun foo(input : String) {
        client.sendData(input)
    }
}