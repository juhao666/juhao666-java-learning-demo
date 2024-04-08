package com.juhao666.design.pattern.bridge.brand;

import com.juhao666.design.pattern.bridge.app.MobileApp;

public abstract class MobileBrand {
    protected MobileApp app;

    public void setApp(MobileApp app) {
        this.app = app;
    }

    public abstract void run();
}
