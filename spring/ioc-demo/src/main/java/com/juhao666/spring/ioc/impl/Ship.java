package com.juhao666.spring.ioc.impl;

import com.juhao666.spring.ioc.Driveable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ship implements Driveable {
    public void drive() {
        log.info("ship......");
    }
}
