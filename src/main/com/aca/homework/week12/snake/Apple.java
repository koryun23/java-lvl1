package com.aca.homework.week12.snake;

public class Apple extends Cell{

    public Apple(int row, int col) {
        super(row, col, CellState.APPLE);
    }

    @Override
    public CellState getState(){
        return CellState.APPLE;
    }

    // need to implement
    public void generate(){

    }
}
