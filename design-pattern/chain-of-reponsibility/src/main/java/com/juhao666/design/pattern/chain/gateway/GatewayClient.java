package com.juhao666.design.pattern.chain.gateway;

import com.juhao666.design.pattern.chain.gateway.factory.GatewayHandlerEnumFactory;

public class GatewayClient {
    public static void main(String[] args) {
        GatewayHandler firstGetewayHandler = GatewayHandlerEnumFactory.getFirstGatewayHandler();
        firstGetewayHandler.service();
    }
}
