package com.aca.homework.week12.snake;

import java.util.function.Supplier;

public class MoveSupplierForTest implements Supplier<String> {

    private String[] moves;
    private int index = 0;

    public MoveSupplierForTest(String[] moves) {
        this.moves = moves;
    }

    @Override
    public String get() {
        if (index >= moves.length)
            return null;
        return moves[index++];
    }
}
