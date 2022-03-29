package com.aca.homework.week12.snake;

public class SnakeBodyCell extends Cell {

    private SnakeBodyCell next;

    public SnakeBodyCell(int row, int col, CellState state) {
        super(row, col, state);
    }

    public SnakeBodyCell next(){
        return next;
    }

    public void setNext(SnakeBodyCell next){
        this.next = next;
    }
}
