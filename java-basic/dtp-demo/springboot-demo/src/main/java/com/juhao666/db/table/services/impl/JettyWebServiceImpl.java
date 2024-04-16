package com.juhao666.db.table.services.impl;

import com.juhao666.db.table.services.WebService;

public class JettyWebServiceImpl implements WebService {
    @Override
    public void start() {
        System.out.println("start Jetty");
    }
}
