package com.aca.homework.week4.snake.improved;

public class BodyCell extends Cell{
    private BodyCell next;
    private CellType type;

    public BodyCell(int row, int col, CellType type, BodyCell next){
        super(row, col);
        this.type = type;
        this.next = next;
    }

    public BodyCell getNext() {
        return next;
    }

    public void setNext(BodyCell next) {
        this.next = next;
    }



    public boolean isHead(){
        return CellType.HEAD == this.type;
    }

    @Override
    public CellType getType(){
        return type;
    }
    @Override
    public String toString(){
        Colors color = isHead() ? Colors.RED : Colors.ORANGE;
        return color + "*" + Colors.RESET;
    }

}
