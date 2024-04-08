package com.juhao666.design.pattern.mediator.colleague;

import com.juhao666.design.pattern.mediator.mediator.UnitedNations;

public class USA extends Country {
    public USA(UnitedNations un) {
        super(un);
    }

    @Override
    public void outputMessage(String message) {
        System.out.println("USA received message is " + message);
    }
}
