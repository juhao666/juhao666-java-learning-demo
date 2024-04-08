package com.juhao666.design.pattern.bridge.app;

import com.juhao666.design.pattern.bridge.app.MobileApp;

public class MobileGame extends MobileApp {
    @Override
    public void run() {
        System.out.println("run mobile game app now...");
    }
}
