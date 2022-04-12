package com.aca.homework.week4.color.pixel;

public class ColorPixel extends Pixel{
    private String color;
    public ColorPixel(int x, int y, String color){
        super(x, y);
        this.color = color;
    }

    public String getColor(){
        return this.color;
    }

}
