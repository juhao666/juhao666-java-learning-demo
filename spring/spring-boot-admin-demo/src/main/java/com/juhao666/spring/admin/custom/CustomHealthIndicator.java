package com.juhao666.spring.admin.custom;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CustomHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        boolean result = check();
        if (!result){
            return Health.down().withDetail("message","encounter error").build();
        }
        return Health.up().build();
    }

    private boolean check() {
        int random = new Random().nextInt(10);
        return random % 2 == 0;
    }
}
