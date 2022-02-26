package com.aca.homework.week7.singleton;

public class SingletonUserService {
    private static SingletonUserService instance;

    private SingletonUserService(){}

    public static SingletonUserService getInstance(){
        if(instance != null){
            return instance;
        }
        instance = new SingletonUserService();
        return instance;
    }
}
