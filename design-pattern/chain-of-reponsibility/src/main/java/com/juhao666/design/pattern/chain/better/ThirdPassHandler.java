package com.juhao666.design.pattern.chain.better;

public class ThirdPassHandler extends AbstractHandler {

    private int play() {
        return 95;
    }

    @Override
    public boolean ifPass() {
        System.out.println("The 3rd-->ThirdPassHandler-->last one");
        return 95 <= play();
    }
}

