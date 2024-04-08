package com.juhao666.design.pattern.chain.better;

public abstract class AbstractHandler {

    protected AbstractHandler next;

    public void setNext(AbstractHandler next) {
        this.next = next;
    }

    public boolean pass() {
        if (ifPass()) {
            if (null != next) {
                return next.pass();
            }
            return true;
        }
        return false;
    }

    public abstract boolean ifPass();
}
