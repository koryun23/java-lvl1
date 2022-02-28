package com.aca.classwork.week8.exception;

public class CheckedMain {
    public static void main(String[] args) throws Exception{
        try {
            createUser();
        }catch(UserCreationException e){
            e.printStackTrace();
            System.out.println(e.getAnimal());
            throw new RuntimeException();
        }
    }

    public static void createUser() throws Exception{
        throw new Exception();
    }
}
