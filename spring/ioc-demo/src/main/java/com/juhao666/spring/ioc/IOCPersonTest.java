package com.juhao666.spring.ioc;

import com.juhao666.spring.ioc.impl.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IOCPersonTest {
    private ContainerSimulator container;

    @BeforeEach
    public void start(){
        container = new ContainerSimulator();
        container.put(Bike.class, new Bike());
        container.put(Car.class, new Car());
        container.put(Train.class, new Train());
        container.put(AirPlane.class, new AirPlane());
        container.put(Ship.class, new Ship());
    }

    @Test
    public void testTravel(){
        //配置好要使用的实现类即可。(注入)
        Driveable driver = container.get(Bike.class);
        IOCPerson person = new IOCPerson(driver);
        person.travel();
    }
}
