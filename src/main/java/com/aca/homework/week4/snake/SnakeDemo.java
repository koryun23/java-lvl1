package com.aca.homework.week4.snake;

public class SnakeDemo {
    public static void main(String[] args) {
        SnakeGame snakeGame = new SnakeGame();
        snakeGame.show();
        while (snakeGame.isGameRunning()) {
            snakeGame.play();
        }
    }
}
