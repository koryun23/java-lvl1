package com.aca.homework.week12.snake;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Board board;
    private Snake snake;
    private Apple apple;
    private boolean isRunning = true;

    public Game(Board board) {
        this.board = board;
        this.snake = board.getSnake();
        this.apple = board.getApple();
    }

    public void start() {
        System.out.println("The game starts!");
        while(isRunning) {
            String move = getMove();
            if(!isValidMove(move)) {
                System.out.println("The move must be one of these options: A D W S");
                continue;
            }

        }
    }

    public String getMove(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public boolean isValidMove(String move) {
        return new HashSet<>(List.of("a", "d", "w", "d")).contains(move);
    }
}
