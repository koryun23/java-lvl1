package com.aca.homework.week4.snake;

public class SnakeDemo {
    public static void main(String[] args) {
        Snake snake = new Snake();
        snake.show();
        while(snake.isGameRunning()){
            snake.move();
        }
    }
}
