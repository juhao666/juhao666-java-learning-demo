package com.juhao666.design.pattern.decorator.sample.impl;

import com.juhao666.design.pattern.decorator.sample.ICharacter;

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
