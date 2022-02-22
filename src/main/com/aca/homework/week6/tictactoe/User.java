package com.aca.homework.week6.tictactoe;

public class User {
    private String username;

    public User(String username){
        this.username = username;
    }


    public String getUsername() {
        return username;
    }

    @Override
    public String toString(){
        return getUsername();
    }
}
