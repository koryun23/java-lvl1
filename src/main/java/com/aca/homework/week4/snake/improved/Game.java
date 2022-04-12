package com.aca.homework.week4.snake.improved;

import java.util.Scanner;

public class Game {
    private Snake snake;
    private BodyCell snakeHead;
    private Apple apple;
    private Board board;
    private boolean running;

    public Game(){
        snake = new Snake(0, 0);
        snakeHead = snake.getHead();
        apple = new Apple(2, 1);
        board = new Board(snake, apple);
        running = true;
    }

    public void play() {
        int[] directions = getMoveDirection();
        int dirX = directions[0];
        int dirY = directions[1];

        if (!moveIsLegal(dirX, dirY)) {
            return;
        }
        if (snake.isOutOfBounds(dirX, dirY, board)) {
            System.out.println("You lost");
            running = false;
            return;
        }
        if(snake.eatsAppleOnNextMove(dirX, dirY, apple)){
            // generate new apple
            apple = apple.generateNewApple(board);

        }


    }

    public boolean moveIsLegal(int dirX, int dirY) {
        BodyCell neck = snakeHead.getNext();
        return neck.getRow() == snakeHead.getRow() + dirY && neck.getCol() == snakeHead.getCol() + dirX;
    }

    public int[] getMoveDirection() {
        // accept move
        Move move = getMove();
        int dirX = 0, dirY = 0;
        if (move == Move.UP) dirY--;
        else if (move == Move.DOWN) dirY++;
        else if (move == Move.LEFT) dirX--;
        else if (move == Move.RIGHT) dirX++;

        return new int[]{dirX, dirY};
    }

    public Move getMove() {
        Scanner scanner = new Scanner(System.in);
        String move = scanner.nextLine();
        if (isValidMove(move)) {
            if ("w".equals(move)) return Move.UP;
            if ("a".equals(move)) return Move.LEFT;
            if ("d".equals(move)) return Move.RIGHT;
            if ("s".equals(move)) return Move.DOWN;
        }
        return Move.NOMOVE;
    }

    public boolean isValidMove(String move) {
        return "w".equals(move) || "a".equals(move) || "d".equals(move) || "s".equals(move);
    }
}
