package com.juhao666.common;

import lombok.Data;
import lombok.ToString;

/**
 * 值传递 VS 引用传递
 *
 *
 * 引用传递：内容被修改。
 * before updateAge =====>MethodParameterTest.User(name=juhao666, age=10)
 * after  updateAge =====>MethodParameterTest.User(name=juhao666, age=20)
 *
 * 值传递：内容不会被修改。
 * before updateIntegerX =====>10
 * after  updateIntegerX =====>10
 * before updateIntX =====>10
 * after  updateIntX =====>10
 * before updateString =====>10
 * after  updateString =====>10
 */
public class MethodParameterTest {
    public static void main(String[] args) {
        User user = new User("juhao666",10);
        System.out.println("before updateAge =====>"+user);
        updateAge(user, 20);
        System.out.println("after  updateAge =====>"+user);

        Integer x =10;
        System.out.println("before updateIntegerX =====>"+x);
        updateIntegerX(x, 20);
        System.out.println("after  updateIntegerX =====>"+x);

        int a = 10;
        System.out.println("before updateIntX =====>"+a);
        updateIntX(a,20);
        System.out.println("after  updateIntX =====>"+a);

        String s = "10";
        System.out.println("before updateString =====>"+s);
        updateString(s,"20");
        System.out.println("after  updateString =====>"+s);
    }

    public static void updateAge(User user, Integer y){
        user.setAge(y);
    }

    public static void updateIntegerX(Integer x, Integer y){
        x = y;
    }

    public static void updateIntX(int x, int y){
        x = y;
    }

    public static void updateString(String x, String y){
        x = y;
    }

    @Data
    @ToString
    static class User{
        private String name;
        private Integer age;

        public  User(String name, Integer age){
            this.name = name;
            this.age =age;
        }
    }
}
