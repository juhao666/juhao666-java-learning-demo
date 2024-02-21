package com.juhao666.common;

import lombok.Data;

public class InnerStaticClassTest {
    @Data
    public class User {
        String name;
        String age;
        Phone phone;

        @Data
        public static class Phone {
            String phoneNo;
        }
    }

    public User getUser() {
        return new User();
    }

    public static void main(String[] args) {
        InnerStaticClassTest myClass = new InnerStaticClassTest();

        User user1 = myClass.getUser();
        user1.setName("User1");
        user1.setAge("10");
        //how to create phone number here
        User.Phone phone1 = new User.Phone();
        phone1.setPhoneNo("123-456-7890");
        user1.setPhone(phone1);

        System.out.println(user1.getName() + " : " + user1.getPhone().getPhoneNo());

        User user2 = myClass.getUser();

        user2.setName("User2");
        System.out.println(user2.getName() + " : " + user2.getPhone().getPhoneNo());


    }
}
