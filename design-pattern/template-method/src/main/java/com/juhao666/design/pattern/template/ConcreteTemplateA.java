package com.juhao666.design.pattern.template;

public class ConcreteTemplateA extends AbstractTemplate{
    @Override
    protected void templateMethod2() {
        System.out.println("this is template A method2");
    }

    @Override
    protected void templateMethod1() {
        System.out.println("this is template A method1");
    }
}
