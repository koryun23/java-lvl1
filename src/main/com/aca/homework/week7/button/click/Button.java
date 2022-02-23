package com.aca.homework.week7.button.click;

public class Button {
    private final String text;

    public Button(String text) {
        this.text = text;
    }

    public void click(Action action) {
        action.doAction();
    }
}
