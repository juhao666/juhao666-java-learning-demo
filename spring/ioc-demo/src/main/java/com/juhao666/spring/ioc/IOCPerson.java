package com.juhao666.spring.ioc;

public class IOCPerson {
    private Driveable driveable;

    public  IOCPerson(Driveable driveable){
        this.driveable=driveable;
    }

    //no code change even if any new transportation
    public void travel(){
        driveable.drive();
    }
}
