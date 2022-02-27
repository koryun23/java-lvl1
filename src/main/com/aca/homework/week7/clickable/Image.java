package com.aca.homework.week7.clickable;

public class Image extends AbstractClickable implements Clickable {
    public Image(String name, Action action) {
        super(name, action);
    }

    @Override
    public String name() {
        return getName();
    }

    @Override
    public String toString() {
        return "image";
    }
}
