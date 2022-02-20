package com.aca.homework.week4.snake.improved;

public class Cell {
    private int row;
    private int col;

    public Cell(int row, int col){
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public CellType getType(){
        return CellType.EMPTY;
    }
    @Override
    public String toString(){
        return Colors.WHITE + "0" + Colors.RESET;
    }
}
