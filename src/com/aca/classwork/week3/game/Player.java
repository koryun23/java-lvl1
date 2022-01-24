package com.aca.classwork.week3.game;
import java.util.Arrays;

public class Player {
    String username;
    String name;
    Game[] games = new Game[2];

    public void print(){
        String name = "Name: "+ this.name;
        String username = "Username: "+this.username;
        System.out.println(username);
        System.out.println(name);
        System.out.println("games");
        for(int i = 0; i < this.games.length; i++) {
            this.games[i].print();
        }

    }

}
