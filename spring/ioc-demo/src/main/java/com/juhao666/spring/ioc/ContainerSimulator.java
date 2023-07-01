package com.juhao666.spring.ioc;

import java.util.HashMap;
import java.util.Map;

public class ContainerSimulator {
    Map<Class<?>, Object> beans = new HashMap<>();

    public <T> T get(Class<T> key) {
        return (T) beans.get(key);
    }

    public <T> void put(Class<T> key, T value) {
        beans.put(key, value);
    }
}
