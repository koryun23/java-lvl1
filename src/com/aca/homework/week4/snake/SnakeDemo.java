package com.aca.homework.week4.snake;

public class SnakeDemo {
    public static void main(String[] args) {
        char[][] board = new char[8][8];
        fillWithZeroes(board);
        Snake snake = new Snake(board, 0, 0, 2, 1);
        printMatrix(board);
        while(true){
            snake.move();
        }
    }
    public static void fillWithZeroes(char[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = '0';
            }
        }
    }
    public static void printMatrix(char[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
