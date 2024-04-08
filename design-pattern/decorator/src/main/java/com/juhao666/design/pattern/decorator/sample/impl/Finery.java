package com.juhao666.design.pattern.decorator.sample.impl;

import com.juhao666.design.pattern.decorator.sample.ICharacter;

/**
 * Decorator Class !!!!!!!
 */
public class Finery implements ICharacter {
    ICharacter component;

    //important here
    public void decorate(ICharacter component){
        this.component = component;
    }

    @Override
    public void show() {
        this.component.show();;
    }
}
