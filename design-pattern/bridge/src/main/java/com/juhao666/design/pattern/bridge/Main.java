package com.juhao666.design.pattern.bridge;

import com.juhao666.design.pattern.bridge.app.MobileChat;
import com.juhao666.design.pattern.bridge.app.MobileGame;
import com.juhao666.design.pattern.bridge.brand.Honor;
import com.juhao666.design.pattern.bridge.brand.IPhone;
import com.juhao666.design.pattern.bridge.brand.MobileBrand;

public class Main {
    public static void main(String[] args) {
        MobileBrand honor = new Honor();
        honor.setApp(new MobileChat());
        honor.run();;

        honor.setApp(new MobileGame());
        honor.run();
    }
}