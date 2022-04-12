package com.aca.classwork.week6.figure.hierarchy;

public class RectangleFigure implements Figure {
    private double width;
    private double height;

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString(){
        return String.format("Rectangle:\nwidth: %.2f\nheight: %.2f\narea: %.2f\nperimeter: %.2f",
                width, height, area(), perimeter());
    }
}
