package com.juhao666.design.pattern.chain.gateway.dao;

import com.juhao666.design.pattern.chain.gateway.entity.GatewayEntity;

public interface  GatewayDao {
    /**
     * 根据 handlerId 获取配置项
     * @param handlerId
     * @return
     */
    GatewayEntity getGatewayEntity(Integer handlerId);

    /**
     * 获取第一个处理者
     * @return
     */
    GatewayEntity getFirstGatewayEntity();
}
