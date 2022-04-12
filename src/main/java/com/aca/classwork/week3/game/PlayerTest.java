package com.aca.classwork.week3.game;

import java.util.Arrays;

public class PlayerTest {
    public static void main(String[] args) {
        Game game1 = new Game();
        game1.name = "game 1";
        Game game2 = new Game();
        game2.name = "game 2";
        Game[] allGames = {game1, game2};
        Player player1 = new Player();
        player1.games = allGames;
        player1.username = "player1";
        player1.name = "Player One";
        player1.print();
    }


}
