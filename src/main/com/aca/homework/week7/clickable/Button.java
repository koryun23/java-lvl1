package com.aca.homework.week7.clickable;

public class Button extends AbstractClickable implements Clickable {
    String name;

    public Button(String name, Action action) {
        super(action);
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String toString(){
        return "button";
    }
}
