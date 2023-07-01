package com.juhao666.design.pattern.chain.gateway.enums;

import com.juhao666.design.pattern.chain.gateway.entity.GatewayEntity;

public enum GatewayEnum {
    // handlerId, 拦截者名称，全限定类名，preHandlerId，nextHandlerId
    API_HANDLER(new GatewayEntity(1, "api接口限流", "com.juhao666.design.pattern.chain.gateway.impl.ApiLimitGatewayHandler", null, 2)),
    BLACKLIST_HANDLER(new GatewayEntity(2, "黑名单拦截", "com.juhao666.design.pattern.chain.gateway.impl.BlacklistGatewayHandler", 1, 3)),
    SESSION_HANDLER(new GatewayEntity(3, "用户会话拦截", "com.juhao666.design.pattern.chain.gateway.impl.SessionGatewayHandler", 2, null)),
    ;

    GatewayEntity gatewayEntity;

    public GatewayEntity getGatewayEntity() {
        return gatewayEntity;
    }

    GatewayEnum(GatewayEntity gatewayEntity) {
        this.gatewayEntity = gatewayEntity;
    }
}
