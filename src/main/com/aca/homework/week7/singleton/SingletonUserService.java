package com.aca.homework.week7.singleton;

public class SingletonUserService {
    private static SingletonUserService user;

    private SingletonUserService(){}

    public static SingletonUserService getInstance(){
        if(userExists(user)){
            return user;
        }
        assignUserToNewObject();
        return user;
    }

    public static boolean userExists(SingletonUserService user){
        return user!= null;
    }

    public static void assignUserToNewObject(){
        user = new SingletonUserService();
    }
}
