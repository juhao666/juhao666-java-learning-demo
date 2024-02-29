package com.juhao666.design;

import com.juhao666.design.sample.Sneakers;
import com.juhao666.design.sample.TShirts;
import com.juhao666.design.sample.impl.Person;

public class SampleMain {
    public static void main(String[] args) {
        Person person = new Person("ACat");

        Sneakers sk = new Sneakers();
        TShirts tShirt = new TShirts();

        sk.decorate(person);
        tShirt.decorate(sk);

        tShirt.show();
    }
}