package com.aca.homework.week4.color.pixel;

public class ColorPixel extends Pixel{
    private int x;
    private int y;
    private String color;
    public ColorPixel(int x, int y, String color){
        super(x, y);
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public String getColor(){
        return this.color;
    }

}
