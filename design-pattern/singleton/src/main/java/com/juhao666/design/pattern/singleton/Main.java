package com.juhao666.design.pattern.singleton;

public class Main {
    public static void main(String[] args) {
        ConcreteObject concreteObject1 = Singleton.getInstance();
        ConcreteObject concreteObject2 = Singleton.getInstance();

        //the instance should live in one container, try to start the App as SpringBoot application
        System.out.println("the 1st ConcreteObject is " + concreteObject1);
        System.out.println("the 2nd ConcreteObject is " + concreteObject2);
        System.out.println(String.format("the 2 object are the same one ? %s", concreteObject2==concreteObject1));
    }
}