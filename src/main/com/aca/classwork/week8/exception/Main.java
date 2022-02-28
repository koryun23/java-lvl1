package com.aca.classwork.week8.exception;

public class Main {
    public static void main(String[] args) {
        try{
            User user = createUser();
            System.out.println(user.getFirstName());
        }catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }

    public static User createUser() {
        User user = null;
        try {
            user = new User(null, "first name");
        } catch(IllegalArgumentException e){
            e.printStackTrace();
        }

        user = new User("ignore", "ignore");

        return user;
    }
}
