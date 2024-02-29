package com.juhao666.design.sample.impl;

import com.juhao666.design.sample.ICharacter;

/**
 * Concrete Component
 */
public class Person implements ICharacter {

    String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void show() {
        System.out.println(" decorator for " + name);
    }
}
