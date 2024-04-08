package com.juhao666.design.pattern.decorator.sample;

import com.juhao666.design.pattern.decorator.sample.impl.Finery;

public class TShirts extends Finery {

    public void show(){
        System.out.print(" T-shirt");
        super.show();;
     }
}
