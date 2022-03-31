package com.aca.homework.week12.snake;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

public class Game {

    private final Board board;
    private final Snake snake;
    private final Apple apple;
    private final Listener listener;
    private boolean isRunning = true;
    private final Supplier<String> moveSupplier;

    public Game(Board board, Supplier<String> moveSupplier) {
        this.board = board;
        this.snake = board.getSnake();
        this.apple = board.getApple();
        this.moveSupplier = moveSupplier;
        listener = new AppleListener(apple);
    }

    public void start() {
        System.out.println("The game starts!");
        while (isRunning) {
            board.updateBoard();
            board.print();
            String move = moveSupplier.get();
            if (!Direction.isValidMove(move)) {
                System.out.println("The move must be one of these options: A D W S");
                continue;
            }
            Direction direction = Direction.of(move);

            if (listener.changeDetected()) {
                snake.extend(direction.getDeltaRowAndCol()[0], direction.getDeltaRowAndCol()[1]);
            } else {
                snake.move(direction.getDeltaRowAndCol()[0], direction.getDeltaRowAndCol()[1]);
            }

            if (snake.snakeCollidedApple(apple)) {
                apple.generate(board);
            } else if (snake.headOutOfBounds(board) || snake.snakeHeadCollidedWithBody()) {
                System.out.println("You lost.");
                isRunning = false;
            }
        }
    }
}
