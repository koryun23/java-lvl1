package com.aca.homework.week21.button.state;

import java.util.Objects;

public class ButtonOnState implements ButtonState {

    private final ColorType color;

    public ButtonOnState(ColorType color) {
        this.color = color;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public ColorType getColor() {
        return color;
    }

    @Override
    public ButtonState nextState() {
        return new ButtonOffState(ColorType.GRAY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ButtonOnState that = (ButtonOnState) o;
        return color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }

    @Override
    public String toString() {
        return "ButtonOnState{" +
                "color=" + color +
                '}';
    }
}
