package com.juhao666.design.pattern.chain.gateway;

public abstract class GatewayHandler {

    protected  GatewayHandler next;



    public void setNext(GatewayHandler next){
        this.next = next;
    }

    public abstract void service();

}
