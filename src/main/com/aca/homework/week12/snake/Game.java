package com.aca.homework.week12.snake;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Game {

    private final Board board;
    private final Snake snake;
    private final Apple apple;
    private final boolean isRunning = true;
    private final Listener listener;

    public Game(Board board) {
        this.board = board;
        this.snake = board.getSnake();
        this.apple = board.getApple();
        listener = new AppleListener(apple);
    }

    public void start() {
        System.out.println("The game starts!");
        while (isRunning) {
            board.updateBoard();
            board.print();
            String move = getMove();
            if (!Direction.isValidMove(move)) {
                System.out.println("The move must be one of these options: A D W S");
                continue;
            }
            Direction direction = Direction.of(move);

            if(listener.changeDetected()) {
                snake.extend(direction.getDeltaRowAndCol()[0], direction.getDeltaRowAndCol()[1]);
            }else {
                snake.move(direction.getDeltaRowAndCol()[0], direction.getDeltaRowAndCol()[1]);
            }

            if (snakeCollidedApple()) {
                apple.generate(board);
            }

        }
    }

    public String getMove() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public boolean snakeCollidedApple() {
        SnakeHead head = snake.snakeHead();
        return head.getRow() == apple.getRow() && head.getCol() == apple.getCol();
    }
}
