package com.aca.classwork.week8.exception;

public class UserCreationException extends RuntimeException{
    public UserCreationException(String message){
        super(message);
    }

    public Animal getAnimal(){
        return Animal.CAT;
    }
}
