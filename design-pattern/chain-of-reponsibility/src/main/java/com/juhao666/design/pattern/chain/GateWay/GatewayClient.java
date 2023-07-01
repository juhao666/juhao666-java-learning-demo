package com.juhao666.design.pattern.chain.GateWay;

import com.juhao666.design.pattern.chain.GateWay.factory.GatewayHandlerEnumFactory;

public class GatewayClient {
    public static void main(String[] args) {
        GatewayHandler firstGetewayHandler = GatewayHandlerEnumFactory.getFirstGatewayHandler();
        firstGetewayHandler.service();
    }
}
