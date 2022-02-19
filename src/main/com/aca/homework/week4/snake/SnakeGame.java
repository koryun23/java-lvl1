package com.aca.homework.week4.snake;

import java.util.Random;
import java.util.Scanner;

public class SnakeGame {
    private final char[][] board = new char[8][8];
    private int[][] snake; // I thought it would be a better idea to use stack instead of an array, but anyways I left it this way
    private int snakeSize = 1;
    private int appleRow = 2;
    private int appleCol = 1;
    private int headRow = 0;
    private int headCol = 0;
    private boolean running = true; // if the player loses, the variable becomes false

    public SnakeGame() {
        initializeBoard();
        initializeSnake();
        this.board[headRow][headCol] = '*';
        this.board[appleRow][appleCol] = '=';
    }

    public static String resetColor() {
        return "\033[0m";
    }

    public static String getRed() {
        return "\033[1;31m";
    }

    public static String getOrange() {
        return "\033[1;34m";
    }

    public static String getYellow() {
        return "\033[1;33m";
    }

    public static String getWhite() {
        return "\033[1;37m";
    }

    public String getMove() {
        Scanner scanner = new Scanner(System.in);
        String move = scanner.nextLine();
        return move;
    }

    public boolean snakeCannotMove(int dirX, int dirY) {
        return this.snakeSize > 1 && this.snake[0][0] + dirY == this.snake[1][0] && this.snake[0][1] + dirX == this.snake[1][1];
    }

    public boolean snakeAteAppleOnPrevMove(int dirX, int dirY) {
        return snake[0][0] + dirY == this.appleRow && this.snake[0][1] + dirX == this.appleCol;
    }

    public boolean snakeEatsAppleOnNextMove(int dirX, int dirY) {
        return this.snake[0][0] == this.appleRow && this.snake[0][1] == this.appleCol;
    }

    public void endGameAfterLosing() {
        System.out.println("You lose");
        this.running = false;
    }

    public void moveAfterEatingAppleOnPrevMove(int dirX, int dirY) {
        this.updateSnake(dirY, dirX);
        this.updateBoard();
        this.generateApple();
        this.show();
        this.snakeSize++;
    }

    public void eatAppleAfterMoving(int dirX, int dirY) {
        int[] snakeHead = this.snake[0];
        this.board[snakeHead[0] + dirY][snakeHead[1] + dirX] = '*';
        this.updateSnake(dirY, dirX);
        this.updateBoard();
        this.show();
    }

    public void move(int dirX, int dirY) {
        this.updateSnake(dirY, dirX);
        this.updateBoard();
        this.show();
        if (this.snakeBitItself()) {
            endGameAfterLosing();
        }
    }

    public int[] getMoveDirection(String move) {
        int dirX = 0, dirY = 0;
        if ("w".equals(move)) {
            dirY = -1;
        } else if ("s".equals(move)) {
            dirY = 1;
        } else if ("a".equals(move)) {
            dirX = -1;
        } else if ("d".equals(move)) {
            dirX = 1;
        }
        return new int[]{dirX, dirY};
    }

    public boolean invalidMove(String move) {
        return !("w".equals(move) || "a".equals(move) || "d".equals(move) || "s".equals(move));
    }

    public void play() {
        String move = this.getMove();
        if (invalidMove(move)) {
            System.out.println("Could not understand the command.");
            return;
        }
        int[] directions = getMoveDirection(move);
        int dirX = directions[0];
        int dirY = directions[1];

        if (snakeCannotMove(dirX, dirY)) {
            return;
        }
        if (isOutOfBounds(snake[0][0] + dirY, snake[0][1] + dirX)) { // checking if the snake will leave the board on the next turn
            endGameAfterLosing();
            return;
        }

        if (snakeAteAppleOnPrevMove(dirX, dirY)) {
            moveAfterEatingAppleOnPrevMove(dirX, dirY);
        } else if (snakeEatsAppleOnNextMove(dirX, dirY)) {
            eatAppleAfterMoving(dirX, dirY);
        } else {
            move(dirX, dirY);
        }
    }

    public void generateApple() {
        System.out.println("Generating apples");
        int newAppleRow = -1, newAppleCol = -1;
        while (!cellIsEmpty(newAppleRow, newAppleCol)) {
            Random generator = new Random();
            newAppleRow = generator.nextInt(this.board.length);
            newAppleCol = generator.nextInt(this.board[0].length);
        }
        this.board[newAppleRow][newAppleCol] = '=';
        this.appleRow = newAppleRow;
        this.appleCol = newAppleCol;

    }

    public void updateSnake(int dirRow, int dirCol) {
        for (int i = snakeSize; i > 0; i--) {
            snake[i][0] = snake[i - 1][0];
            snake[i][1] = snake[i - 1][1];
        }
        snake[0][0] += dirRow;
        snake[0][1] += dirCol;
        headRow = snake[0][0];
        headCol = snake[0][1];

    }

    public void updateBoard() {
        this.initializeBoard();
        this.board[appleRow][appleCol] = '=';
        for (int i = 0; i < snakeSize; i++) {
            this.board[snake[i][0]][snake[i][1]] = '*';
        }
    }

    public void show() {
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {
                if (isHead(i, j)) {
                    printHead(i, j);
                } else if (isBodyPart(i, j)) {
                    printBodyPart(i, j);
                } else if (isApple(i, j)) {
                    printApple(i, j);
                } else {
                    printEmptyCell(i, j);
                }
            }
            System.out.println();
        }
    }

    public void printHead(int i, int j) {
        System.out.print(getRed() + this.board[i][j] + " " + resetColor());
    }

    public void printBodyPart(int i, int j) {
        System.out.print(getOrange() + this.board[i][j] + " " + resetColor());
    }

    public void printApple(int i, int j) {
        System.out.print(getYellow() + this.board[i][j] + " " + resetColor());
    }

    public void printEmptyCell(int i, int j) {
        System.out.print(getWhite() + this.board[i][j] + " " + resetColor());

    }

    public boolean isHead(int i, int j) {
        return i == snake[0][0] && j == snake[0][1] && this.board[i][j] == '*';
    }

    public boolean isBodyPart(int i, int j) {
        return this.board[i][j] == '*';
    }

    public boolean isApple(int i, int j) {
        return this.board[i][j] == '=';
    }

    public void initializeBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = '0';
            }
        }
    }

    public void initializeSnake() {
        this.snake = new int[board.length * board[0].length][2]; // snake array represents the cells occupied by the snake
        this.snake[snakeSize - 1][0] = this.headRow;
        this.snake[snakeSize - 1][1] = this.headCol;
    }

    public boolean cellIsEmpty(int row, int col) {
        return !isOutOfBounds(row, col) && this.board[row][col] == '0';
    }

    public boolean isOutOfBounds(int row, int col) {
        return row < 0 || row >= this.board.length || col < 0 || col >= this.board[0].length;
    }

    public boolean snakeBitItself() {
        for (int i = 3; i < this.snakeSize; i++) {
            if (this.snake[0][0] == this.snake[i][0] && this.snake[0][1] == this.snake[i][1]) {
                return true;
            }
        }
        return false;
    }

    public boolean isGameRunning() {
        return this.running;
    }


}
