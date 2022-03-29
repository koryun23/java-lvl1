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
            board.updateBoard();
            board.print();
            String move = getMove();
            if(!Direction.isValidMove(move)) {
                System.out.println("The move must be one of these options: A D W S");
                continue;
            }
            Direction direction = Direction.of(move);
            snake.move(direction.getDeltaRowAndCol()[0], direction.getDeltaRowAndCol()[1]);
            System.out.println(snake.snakeHead().getRow());
            System.out.println(snake.snakeHead().getCol());
        }
    }

    public String getMove(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
