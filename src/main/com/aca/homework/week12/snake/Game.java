package com.aca.homework.week12.snake;

import java.util.function.Supplier;

public class Game {

    private final Board board;
    private final Snake snake;
    private final Apple apple;
    private final Listener listener;
    private boolean isRunning = true;
    private GameState gameState = GameState.RUNNING;
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
        System.out.println(Direction.isValidMove("w"));
        while (isRunning) {
            board.updateBoard();
            board.print();
            String move = moveSupplier.get();
            if(isEnd(move)){
                gameState = GameState.TERMINATED;
                isRunning = false;
                break;
            }

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
            } else if (lostGame()) {
                System.out.println("You lost.");
                isRunning = false;
                gameState = GameState.TERMINATED;
            }
        }
    }

    public GameState getState() {
        return gameState;
    }

    public Listener getAppleListener(){
        return listener;
    }
    public Snake getSnake() {
        return snake.clone();
    }

    private boolean isEnd(String str) {
        return "finish".equals(str);
    }

    private boolean lostGame(){
        return snake.headOutOfBounds(board.getRowCount(), board.getColCount()) || snake.snakeHeadCollidedWithBody();
    }
}
