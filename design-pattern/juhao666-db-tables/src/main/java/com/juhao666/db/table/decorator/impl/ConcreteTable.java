package com.juhao666.db.table.decorator.impl;

public class ConcreteTable extends Table {

    String name;

    public ConcreteTable(String name) {
        this.name = name;
    }

    public void create() {
        System.out.println(String.format("table %s created", name));
        if (this.hasChild) {
            super.create();
        }
    }
}
