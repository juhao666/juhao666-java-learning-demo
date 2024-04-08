package com.juhao666.design.pattern.bridge.brand;

import com.juhao666.design.pattern.bridge.app.MobileApp;
import com.juhao666.design.pattern.bridge.brand.MobileBrand;

public class IPhone extends MobileBrand {
    @Override
    public void run() {
        System.out.println("this is Iphone");
        app.run();
    }
}
