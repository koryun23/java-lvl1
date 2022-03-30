package com.aca.homework.week12.snake;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Snake {

    private final SnakeHead head;
    private int size;

    public Snake(int headRow, int headCol){
        head = new SnakeHead(headRow, headCol);
    }

    public void extend(int deltaHeadRow, int deltaHeadCol){
        if(snakeCannotMove(deltaHeadRow, deltaHeadCol)) return;
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
        if(snakeCannotMove(deltaHeadRow, deltaHeadCol)) return;
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

    public boolean snakeCannotMove(int deltaHeadRow, int deltaHeadCol) {
        int newHeadRow = head.getRow() + deltaHeadRow;
        int newHeadCol = head.getCol() + deltaHeadCol;
        List<SnakeBodyCell> snakeBodyCellList = snakeCoords();
        return snakeBodyCellList.size() > 1 &&
                new SnakeBodyCell(newHeadRow, newHeadCol, CellState.SNAKE_BODY).equals(snakeBodyCellList.get(1));
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

    public boolean snakeHeadCollidedWithBody(){
        for(SnakeBodyCell snakeBodyCell : snakeCoords()) {
            if(snakeBodyCell.getState() != CellState.SNAKE_HEAD && snakeBodyCell.equals(head)) return true;
        }
        return false;
    }

    public boolean headOutOfBounds(Board board) {
        return head.getRow() == -1 || head.getRow() == board.getRowCount() || head.getCol() == -1 || head.getCol() == board.getColCount();
    }

    public boolean snakeCollidedApple(Apple apple) {
        return head.getRow() == apple.getRow() && head.getCol() == apple.getCol();
    }
}
