package com.juhao666.design.pattern.singleton;

/**
 * 2 ways to create a singleton instance
 *  1)
 *  2)
 */
public class Singleton {
    private static volatile  ConcreteObject object;
    private Singleton(){
    }

    public static ConcreteObject getInstance(){
        if (null == object) {
            synchronized (ConcreteObject.class){
                if (null == object) {
                    return new ConcreteObject();
                }
            }
        }
        return object;
    }
}
