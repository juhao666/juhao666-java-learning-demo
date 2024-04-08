package com.juhao666.design.pattern.command;

public class Main {
    public static void main(String[] args) {
        Barbecuer boy = new Barbecuer();
        Command bakeMutton = new BakeMuttonCommand(boy);
        Command bakeChicken = new BakeChickenCommand(boy);
        Waiter girl = new Waiter();

        girl.setOrder(bakeMutton);
        girl.setOrder(bakeMutton);
        girl.setOrder(bakeMutton);
        girl.setOrder(bakeChicken);
        girl.setOrder(bakeMutton);
        girl.setOrder(bakeChicken);

        girl.cancelOrder(bakeMutton);

        girl.notifyCommand();
    }
}