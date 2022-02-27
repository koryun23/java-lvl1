package com.aca.homework.week7.clickable;

public abstract class AbstractClickable implements Clickable {
    private final Action action;
    private final String name;

    public AbstractClickable(String name, Action action) {
        this.action = action;
        this.name = name;
    }

    @Override
    public void click() {
        action.doAction(this);
    }

    public String getName() {
        return name;
    }
}
