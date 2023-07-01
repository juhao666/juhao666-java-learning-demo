package org.example.services.impl;

import org.example.services.WebService;

public class JettyWebServiceImpl implements WebService {
    @Override
    public void start() {
        System.out.println("start Jetty");
    }
}
