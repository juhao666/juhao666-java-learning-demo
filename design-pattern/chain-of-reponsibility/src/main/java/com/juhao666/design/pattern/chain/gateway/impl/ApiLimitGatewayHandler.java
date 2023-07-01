package com.juhao666.design.pattern.chain.gateway.impl;

import com.juhao666.design.pattern.chain.gateway.enums.GatewayEnum;
import com.juhao666.design.pattern.chain.gateway.GatewayHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApiLimitGatewayHandler extends GatewayHandler {
    @Override
    public void service() {
        log.info("this is {}", GatewayEnum.API_HANDLER.getGatewayEntity().getConference());
        if(this.next!=null){
            this.next.service();
        }
    }
}
