package com.aca.homework.week12.snake;

import java.util.LinkedList;
import java.util.List;

public class Snake {

    private final SnakeHead head;
    private int size;

    public Snake(int headRow, int headCol){
        head = new SnakeHead(headRow, headCol);
    }

    public void extend(int deltaHeadRow, int deltaHeadCol){
        SnakeBodyCell newBodyCell = new SnakeBodyCell(head.getRow(), head.getCol(), CellState.SNAKE_BODY);
        head.setRow(head.getRow() + deltaHeadRow);
        head.setCol(head.getCol() + deltaHeadCol);
        newBodyCell.setNext(head.next());
        head.setNext(newBodyCell);
        size++;
    }

    public SnakeHead snakeHead(){
        return head;
    }

    public void move(int deltaHeadRow, int deltaHeadCol){
        SnakeBodyCell headNext = head.next();
        int nextRow = head.getRow();
        int nextCol = head.getCol();
        while(headNext != null) {
            int prevRow = headNext.getRow();
            int prevCol = headNext.getCol();
            headNext.setRow(nextRow);
            headNext.setCol(nextCol);
            nextRow = prevRow;
            nextCol = prevCol;
            headNext = headNext.next();
        }
        head.setRow(head.getRow() + deltaHeadRow);
        head.setCol(head.getCol() + deltaHeadCol);
    }

    public List<SnakeBodyCell> snakeCoords(){
        List<SnakeBodyCell> coords = new LinkedList<>();
        SnakeBodyCell currentBodyCell = head;
        while(currentBodyCell != null) {
            coords.add(currentBodyCell);
            currentBodyCell = currentBodyCell.next();
        }
        return coords;
    }
}
