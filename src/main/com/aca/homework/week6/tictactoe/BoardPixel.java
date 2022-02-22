package com.aca.homework.week6.tictactoe;

public class BoardPixel {
    private State state;

    public BoardPixel(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setBoardPixel(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return state.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj instanceof BoardPixel) {
            BoardPixel other = (BoardPixel) obj;
            return other.getState() == this.getState();
        }
        return false;
    }
}
