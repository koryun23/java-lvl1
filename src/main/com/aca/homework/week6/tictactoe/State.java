package com.aca.homework.week6.tictactoe;

public enum State {
    X,
    O,
    EMPTY {
        @Override
        public String toString() {
            return "*";
        }
    }
}
