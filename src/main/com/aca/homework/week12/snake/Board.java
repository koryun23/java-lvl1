package com.aca.homework.week12.snake;

public class Board {
    private Cell[][] cells;
    private Snake snake;
    private Apple apple;
    private int rowCount;
    private int colCount;

    public Board(int rowCount, int colCount, Apple apple, Snake snake) {
        this.rowCount = rowCount;
        this.colCount = colCount;
        this.apple = apple;
        this.snake = snake;
        cells = new Cell[rowCount][colCount];
        setAllEmpty();
        setApple();
        setSnake();

    }

    public void setApple() {
        cells[apple.getRow()][apple.getCol()] = apple;
    }

    public void setAllEmpty(){
        for(int i = 0; i < rowCount; i++) {
            for(int j = 0; j < colCount; j++) {
                cells[i][j] = new EmptyCell(i, j);
            }
        }
    }

    public void setSnake(){
        SnakeHead head = snake.snakeHead();
        cells[head.getRow()][head.getCol()] = new SnakeHead(head.getRow(), head.getCol());
        while(head.next() != null) {
            SnakeBodyCell nextBodyCell = head.next();
            cells[nextBodyCell.getRow()][nextBodyCell.getCol()] = nextBodyCell;
        }
    }

    public void print(){
        for(int i = 0; i < rowCount; i++) {
            for(int j = 0; j < colCount; j++) {
                System.out.print(cells[i][j].toString() + " ");
            }
            System.out.println();
        }
    }

}
