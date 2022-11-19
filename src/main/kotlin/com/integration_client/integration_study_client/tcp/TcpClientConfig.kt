package com.integration_client.integration_study_client.tcp

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.integration.dsl.IntegrationFlow
import org.springframework.integration.dsl.IntegrationFlows
import org.springframework.integration.ip.dsl.Tcp
import org.springframework.integration.ip.tcp.TcpInboundGateway

@Configuration
class TcpClientConfig {

    @Bean
    fun outBound(): IntegrationFlow {
        val nioClient = Tcp.nioClient("localhost", 9191)
        val factory = nioClient.get()
        val outboundGateway = Tcp.outboundGateway(factory)
        val gateway = outboundGateway.get()
        return IntegrationFlows.from("input")
            .handle(gateway)
            .get()
    }
}