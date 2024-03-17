package com.juhao666.db.table.factory;

public class FactoryFamilyMain {
    public static void main(String[] args) {
        TableFactory.table("father").child("son").child("grandpa");
    }
}
