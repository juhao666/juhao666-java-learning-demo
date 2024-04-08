package com.juhao666.design.pattern.chain.better;

public class FirstPassHandler extends AbstractHandler {

    private int play() {
        return 80;
    }

    @Override
    public boolean ifPass() {
        System.out.println("The 1st-->FirstPassHandler");
        return 80 <= play();
    }
}