package com.juhao666.design.pattern.chain.GateWay;

import com.juhao666.design.pattern.chain.GateWay.Entity.GatewayEntity;

public abstract class GatewayHandler {

    protected  GatewayHandler next;



    public void setNext(GatewayHandler next){
        this.next = next;
    }

    public abstract void service();

}
