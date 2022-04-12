package com.aca.homework.week7.ui;

public class UIText extends UIView{
    private String text;
    private String textColor;

    public UIText(double width, double height, String text, String textColor){
        super(width, height);
        this.text = text;
        this.textColor = textColor;
    }

    @Override
    public String toString(){
        return String.format("text '%s' having a color %s, width: %s, height: %s", text, textColor, getWidth(), getHeight());
    }

    @Override
    public void click(){
        System.out.println(super.toString() + this);
    }
}
