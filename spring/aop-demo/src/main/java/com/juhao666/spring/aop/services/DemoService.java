package com.juhao666.spring.aop.services;

import com.juhao666.spring.aop.annotation.LogExecutionTime;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @LogExecutionTime
    public String getAround() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "around";
    }
}
