package com.aca.homework.week4.snake;

import java.util.Random;
import java.util.Scanner;

public class Snake {
    private char[][] board;
    private int[][] snake;
    private int snakeSize = 1;
    private int appleRow;
    private int appleCol;
    private boolean running = true; // if the player loses, the variable becomes false

    public Snake(char[][] board, int headRow, int headCol, int appleRow, int appleCol) {
        this.board = board;
        this.snake = new int[board.length*board[0].length][2];
        this.snake[snakeSize-1][0] = headRow;
        this.snake[snakeSize-1][1] = headCol;
        this.board[headRow][headCol] = '*';
        this.appleRow = appleRow;
        this.appleCol = appleCol;
        this.board[appleRow][appleCol] = '=';
    }
    public String getMove(){
        Scanner scanner = new Scanner(System.in);
        String move = scanner.nextLine();
        return move;
    }
    public void move(){
        String move = this.getMove();
        int dirX = 0, dirY = 0;
        if("w".equals(move)){
            dirY = -1;
        }else if("s".equals(move)){
            dirY = 1;
        }else if("a".equals(move)){
            dirX = -1;
        }else if("d".equals(move)){
            dirX = 1;
        }


        if(this.snakeSize > 1 && this.snake[0][0]+dirY == this.snake[1][0] && this.snake[0][1]+dirX == this.snake[1][1]){
            return;
        }
        if(this.isOutOfBounds(snake[0][0]+dirY, snake[0][1]+dirX)){
            System.out.println("You lose");
            this.running = false;
            return;
        }
        if(snake[0][0]+dirY == this.appleRow && this.snake[0][1]+dirX == this.appleCol){
            this.updateSnake(dirY, dirX);
            this.updateBoard();
            this.generateApple();
            this.show();
            this.snakeSize++;
        }

        else if (this.snake[0][0] == this.appleRow && this.snake[0][1] == this.appleCol){ // generate a new apple
            int[] snakeHead = this.snake[0];
            this.board[snakeHead[0]+dirY][snakeHead[1]+dirX] = '*';

            this.updateSnake(dirY, dirX);
            this.updateBoard();
            this.show();
        }
        else{
            this.updateSnake(dirY, dirX);
            this.updateBoard();
            this.show();
            // check if after moving the snake bit itself
            if(this.snakeBitItself()){
                System.out.println("You lose");
                this.running = false;
            }
        }
    }
    public void generateApple(){
        System.out.println("Generating apples");
        int newAppleRow = -1, newAppleCol = -1;
        while(!cellIsEmpty(newAppleRow, newAppleCol)){
            Random generator = new Random();
            newAppleRow = generator.nextInt(this.board.length);
            newAppleCol = generator.nextInt(this.board[0].length);
        }
        this.board[newAppleRow][newAppleCol] = '=';
        this.appleRow = newAppleRow;
        this.appleCol = newAppleCol;

    }
    public void updateSnake(int dirRow, int dirCol){
        for(int i = snakeSize; i>0; i--){
            snake[i][0] = snake[i-1][0];
            snake[i][1] = snake[i-1][1];
        }
        snake[0][0] += dirRow;
        snake[0][1] += dirCol;

    }

    public void updateBoard(){
        this.fillWithZeroes();
        this.board[appleRow][appleCol] = '=';
        for(int i = 0; i < snakeSize; i++){
            this.board[snake[i][0]][snake[i][1]] = '*';
        }
    }

    public void show(){
        for(int i = 0; i < this.board.length; i++){
            for(int j = 0; j < this.board[i].length; j++){
                System.out.print(this.board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void fillWithZeroes() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.board[i][j] = '0';
            }
        }
    }

    public boolean cellIsEmpty(int row, int col){
        return !isOutOfBounds(row, col) && this.board[row][col] == '0';
    }
    public boolean isOutOfBounds(int row, int col){
        return row < 0 || row >= this.board.length || col < 0 || col >= this.board[0].length;
    }
    public boolean snakeBitItself(){
        for(int i = 3; i < this.snakeSize; i++){
            if (this.snake[0][0] == this.snake[i][0] && this.snake[0][1] == this.snake[i][1]){
                return true;
            }
        }
        return false;
    }

    public boolean isGameRunning(){
        return this.running;
    }


}
