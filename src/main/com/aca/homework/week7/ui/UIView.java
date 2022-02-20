package com.aca.homework.week7.ui;

public abstract class UIView {
    private double width;
    private double height;

    public UIView(double width, double height){
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public abstract void click();

    @Override
    public String toString(){
        return "Clicked on a ";
    }
}
