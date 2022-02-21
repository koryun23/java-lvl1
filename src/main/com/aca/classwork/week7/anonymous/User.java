package com.aca.classwork.week7.anonymous;

public interface User {
    String getName();
    int getAge();
    static User of(String name, int age){
        return new User(){
            @Override
            public String getName() {
                return null;
            }

            @Override
            public int getAge() {
                return 0;
            }
        };
    }
    static User ofImpl(String name, int age){
        return new UserImpl(name, age);
    }
}
