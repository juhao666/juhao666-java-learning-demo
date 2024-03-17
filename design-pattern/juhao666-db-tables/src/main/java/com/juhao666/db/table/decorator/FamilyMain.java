package com.juhao666.db.table.decorator;


import com.juhao666.db.table.decorator.impl.ConcreteTable;

public class FamilyMain {
    public static void main(String[] args) {

        ConcreteTable grandSon = new ConcreteTable("grandSon");
        ConcreteTable son = new ConcreteTable("son");
        ConcreteTable father = new ConcreteTable("father");

        son.child(grandSon);
        father.child(son);

        father.create();
    }
}