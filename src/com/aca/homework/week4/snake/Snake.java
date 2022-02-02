package com.aca.homework.week4.snake;

import java.util.Random;
import java.util.Scanner;

public class Snake {
    private char[][] board;
    private int[][] snake = new int[8][8];
    private int snakeSize = 1;
    private int appleRow;
    private int appleCol;


    public Snake(char[][] board, int headRow, int headCol, int appleRow, int appleCol) {
        this.board = board;
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

        if(this.snake[0][0]+dirY == this.appleRow && this.snake[0][1]+dirX == this.appleCol){
            this.updateSnake(dirY, dirX);
            this.generateApple();
            this.updateSnakeOnBoard();
            this.show();
            this.snakeSize++;

        }

        else if (this.snake[0][0] == this.appleRow && this.snake[0][1] == this.appleCol){ // generate a new apple
            int[] snakeHead = this.snake[0];
            this.board[snakeHead[0]+dirY][snakeHead[1]+dirX] = '*';

            this.updateSnake(dirY, dirX);
            this.updateSnakeOnBoard();
            this.show();
        }
        else{
            this.updateSnake(dirY, dirX);
            this.updateSnakeOnBoard();
            this.show();
        }
    }
    public void generateApple(){
        System.out.println("Generating apples");
        int newAppleRow = -1, newAppleCol = -1;
        boolean placedApple = false;
        while(!cellIsEmpty(newAppleRow, newAppleCol) && !placedApple){
            Random generator = new Random();
            newAppleRow = generator.nextInt(this.board.length);
            newAppleCol = generator.nextInt(this.board[0].length);
            this.board[newAppleRow][newAppleCol] = '=';
            this.appleRow = newAppleRow;
            this.appleCol = newAppleCol;
            placedApple = true;
        }
    }
    public void updateSnake(int dirRow, int dirCol){
        for(int i = snakeSize; i>0; i--){
            snake[i][0] = snake[i-1][0];
            snake[i][1] = snake[i-1][1];
        }
        snake[0][0] += dirRow;
        snake[0][1] += dirCol;

    }

    public void updateSnakeOnBoard(){
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
        return row < 0 || row > this.board.length || col < 0 || row > this.board[0].length;
    }


}
