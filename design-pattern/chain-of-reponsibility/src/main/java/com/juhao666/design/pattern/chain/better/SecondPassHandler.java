package com.juhao666.design.pattern.chain.better;

public class SecondPassHandler extends AbstractHandler {

    private int play(){
        return 90;
    }

    @Override
    public boolean ifPass() {
        System.out.println("The 2nd-->SecondPassHandler");
        return 90 <= play();
    }
}