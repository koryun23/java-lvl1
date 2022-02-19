package com.aca.homework.week7.ui;

public class UIButton extends UIView {
    private final String buttonColor;

    public UIButton(double width, double height, String buttonColor) {
        super(width, height);
        this.buttonColor = buttonColor;
    }

    @Override
    public void click(){
        System.out.println(super.toString() + this);
    }

    @Override
    public String toString() {
        return String.format("button having a color %s, width: %s, height: %s", buttonColor, getWidth(), getHeight());
    }
}
