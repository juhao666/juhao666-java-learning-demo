package com.juhao666.design.pattern.chain.GateWay.factory;

import com.juhao666.design.pattern.chain.GateWay.Dao.GatewayDao;
import com.juhao666.design.pattern.chain.GateWay.Dao.GatewayImpl;
import com.juhao666.design.pattern.chain.GateWay.Entity.GatewayEntity;
import com.juhao666.design.pattern.chain.GateWay.GatewayHandler;

import java.lang.reflect.InvocationTargetException;

public class GatewayHandlerEnumFactory {
    private static GatewayDao gatewayDao = new GatewayImpl();

    // 提供静态方法，获取第一个handler
    public static GatewayHandler getFirstGatewayHandler() {

        GatewayEntity firstGatewayEntity = gatewayDao.getFirstGatewayEntity();
        GatewayHandler firstGatewayHandler = newGatewayHandler(firstGatewayEntity);
        if (firstGatewayHandler == null) {
            return null;
        }

        GatewayEntity nextGatewayEntity = firstGatewayEntity;
        Integer nextHandlerId = null;
        GatewayHandler nextGatewayHandler = firstGatewayHandler;
        // 迭代遍历所有handler，以及将它们链接起来
        while ((nextHandlerId = nextGatewayEntity.getNextHandlerId()) != null) {
            GatewayEntity gatewayEntity = gatewayDao.getGatewayEntity(nextHandlerId);
            GatewayHandler gatewayHandler = newGatewayHandler(gatewayEntity);
            nextGatewayHandler.setNext(gatewayHandler);
            nextGatewayHandler = gatewayHandler;
            nextGatewayEntity = gatewayEntity;
        }
        // 返回第一个handler
        return firstGatewayHandler;
    }

    /**
     * 反射实体化具体的处理者
     * @param firstGatewayEntity
     * @return
     */
    private static GatewayHandler newGatewayHandler(GatewayEntity firstGatewayEntity) {
        // 获取全限定类名
        String className = firstGatewayEntity.getConference();
        try {
            // 根据全限定类名，加载并初始化该类，即会初始化该类的静态段
            Class<?> clazz = Class.forName(className);
            return (GatewayHandler) clazz.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
