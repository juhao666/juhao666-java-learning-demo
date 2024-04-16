package com.juhao666.design.pattern.template;

public abstract class AbstractTemplate {
    public void method(){
        this.templateMethod1();
        this.templateMethod2();
    }

    protected abstract void templateMethod2();

    protected abstract void templateMethod1();
}
