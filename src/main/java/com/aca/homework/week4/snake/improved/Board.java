package com.aca.homework.week4.snake.improved;

public class Board {
    private int rowCount = 8;
    private int colCount = 8;
    private Cell[][] board = new Cell[rowCount][colCount];

    Snake snake;
    Apple apple;
    public Board(Snake snake, Apple apple){
        this.snake = snake;
        this.apple = apple;
        update();
    }

    public void update(){
        initializeBoard();
        putAppleOnBoard();
        putSnakeOnBoard();
    }

    public void putAppleOnBoard(){
        board[apple.getRow()][apple.getCol()] = apple;
    }
    public void putSnakeOnBoard(){
        BodyCell head = snake.getHead();
        while(head!=null){
            board[head.getRow()][head.getCol()] = head;
            head = head.getNext();
        }
    }
    public void initializeBoard(){
        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                board[i][j] = new Cell(i, j);
            }
        }
    }

    public void print(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j  < board[i].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int getRowCount(){
        return rowCount;
    }

    public int getColCount(){
        return colCount;
    }

    public Cell[][] getBoard(){
        return board;
    }
}
