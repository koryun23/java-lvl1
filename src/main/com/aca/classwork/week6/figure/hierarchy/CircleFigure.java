package com.aca.classwork.week6.figure.hierarchy;

public class CircleFigure implements Figure {
    private double radius;

    public CircleFigure(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString(){
        return String.format("Rectangle:\nradius: %.2f\narea: %.2f\nperimeter: %.2f",
                radius, area(), perimeter());
    }
}
