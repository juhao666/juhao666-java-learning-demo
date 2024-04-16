package com.juhao666.design.pattern.template;

public class Main {
    public static void main(String[] args) {
        AbstractTemplate templateA = new ConcreteTemplateA();
        templateA.method();

        AbstractTemplate templateB = new ConcreteTemplateB();
        templateB.method();
    }
}