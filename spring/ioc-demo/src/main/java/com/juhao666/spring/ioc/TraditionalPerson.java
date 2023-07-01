package com.juhao666.spring.ioc;

import com.juhao666.spring.ioc.impl.*;


public class TraditionalPerson {
    public void travel(){
        //the 1st code change
        Driveable bike = new Bike();
        bike.drive();
        //the 2nd code change
        Driveable car = new Car();
        car.drive();
        //the 3rd code change
        Driveable train = new Train();
        train.drive();
        //the 4th code change
        Driveable airPlane = new AirPlane();
        airPlane.drive();
        //the 5th code change
        Driveable ship = new Ship();
        ship.drive();
    }
}
