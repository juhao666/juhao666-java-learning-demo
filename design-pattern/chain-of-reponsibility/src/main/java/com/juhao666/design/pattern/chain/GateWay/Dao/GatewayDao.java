package com.juhao666.design.pattern.chain.GateWay.Dao;

import com.juhao666.design.pattern.chain.GateWay.Entity.GatewayEntity;

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
