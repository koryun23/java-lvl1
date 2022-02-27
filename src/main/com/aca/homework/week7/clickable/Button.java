package com.aca.homework.week7.clickable;

public class Button extends AbstractClickable implements Clickable {
    public Button(String name, Action action) {
        super(name, action);
    }

    @Override
    public String name() {
        return getName();
    }

    @Override
    public String toString() {
        return "button";
    }
}
