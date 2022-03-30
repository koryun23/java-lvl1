package com.aca.homework.week12.snake;

public class AppleListener implements Listener {

    private int startingAppleRow;
    private int startingAppleCol;
    private final Apple apple;

    public AppleListener(Apple apple) {
        this.apple = apple;
        this.startingAppleRow = apple.getRow();
        this.startingAppleCol = apple.getCol();
    }

    @Override
    public boolean changeDetected() {
        if (apple.equals(new Apple(startingAppleRow, startingAppleCol))) {
            startingAppleCol = apple.getCol();
            startingAppleRow = apple.getRow();
            System.out.println("change detected");
            return true;
        }
        return false;
    }
}
