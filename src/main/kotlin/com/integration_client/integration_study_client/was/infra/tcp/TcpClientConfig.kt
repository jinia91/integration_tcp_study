package com.integration_client.integration_study_client.was.infra.tcp

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.integration.dsl.IntegrationFlow
import org.springframework.integration.dsl.IntegrationFlows
import org.springframework.integration.dsl.Transformers
import org.springframework.integration.ip.dsl.Tcp
import org.springframework.integration.ip.tcp.TcpOutboundGateway

@Configuration
class TcpConfig {

    @Bean
    fun outBound(outBoundGateway : TcpOutboundGateway): IntegrationFlow {
        return IntegrationFlows.from("input")
            .handle(outBoundGateway)
            .transform(Transformers.objectToString())
            .get()
    }

    @Bean
    fun outBoundGateway(): TcpOutboundGateway {
        val netClient = Tcp.netClient("localhost", 9191)
        val factory = netClient.get()
            .apply {
                isSingleUse = true
                isSoKeepAlive = true
            }
        val outboundGateway = Tcp.outboundGateway(factory)
        return outboundGateway.get()
    }
}