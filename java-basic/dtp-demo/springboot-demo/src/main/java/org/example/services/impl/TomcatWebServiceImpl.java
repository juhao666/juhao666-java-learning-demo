package org.example.services.impl;

import org.example.services.WebService;

public class TomcatWebServiceImpl implements WebService {
    @Override
    public void start() {
        System.out.println("start Tomcat");
    }
}
