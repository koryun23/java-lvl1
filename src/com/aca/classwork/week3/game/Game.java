package com.aca.classwork.week3.game;

public class Game {
    String name;
    long shootCount;
    static long fireCount;
    public static void printShootCount(Game game){
        System.out.println(game.shootCount);
    }
    public static void gameTest(){
        Game game1 = new Game();
        game1.name = "game 1";
        game1.shootCount++;
        game1.shootCount++;
        game1.shootCount++;

        Game game2 = new Game();
        game2.name = "game 2";
        game2.shootCount++;

        Game game3 = new Game();
        game3.name = "game 2";

        printShootCount(game1);
        printShootCount(game2);

        printShootCount(game3);
    }
    public void print(){
        System.out.println("Name: "+this.name+"\nShoot: "+this.shootCount);
    }
    public static void print(Game game){
        System.out.println("Name: "+game.name+"\nShoot: "+game.shootCount);
    }

    public static void main(String[] args) {
        Game game1 = new Game();
        game1.name = "game 1";
        Game game2 = new Game();
        game2.name = "game 2";

        for(int i = 0; i < 5; i++){
            game1.fire();
        }
        for(int i = 0; i < 125; i++){
            game2.fire();
        }
        print(game1);
        print(game2);
        printFireTimes();
    }
    public static void printFireTimes(){
        System.out.println("You fired " + fireCount + " times");
    }
    public void fire(){
        this.shootCount++;
        fireCount++;
        System.out.println(this.name + " fire");
    }
}
