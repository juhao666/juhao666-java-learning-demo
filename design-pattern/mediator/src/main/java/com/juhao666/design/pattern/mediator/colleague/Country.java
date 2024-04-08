package com.juhao666.design.pattern.mediator.colleague;

import com.juhao666.design.pattern.mediator.mediator.UnitedNations;

public abstract class Country {
    protected UnitedNations un;
    public Country(UnitedNations un) {
        this.un = un;
    }

    public void declare(String message){
        un.declare(message, this);
    };
    public abstract void outputMessage(String message);
}
