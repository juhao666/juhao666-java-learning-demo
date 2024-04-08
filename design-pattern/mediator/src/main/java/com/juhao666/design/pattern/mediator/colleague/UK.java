package com.juhao666.design.pattern.mediator.colleague;

import com.juhao666.design.pattern.mediator.mediator.UnitedNations;

public class UK extends Country {
    public UK(UnitedNations un) {
        super(un);
    }

    @Override
    public void outputMessage(String message) {
        System.out.println("UK received message is " + message);
    }
}
