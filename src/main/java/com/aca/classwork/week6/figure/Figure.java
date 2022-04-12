package com.aca.classwork.week6.figure;

public class Figure {
    private final FigureType type;
    private double width;
    private double height;
    private double radius;

    private Figure(double width, double height) {
        this.height = height;
        this.width = width;
        type = FigureType.RECTANGLE;
    }

    private Figure(double radius) {
        this.radius = radius;
        type = FigureType.CIRCLE;
    }

    public double area() {
        if (type == FigureType.RECTANGLE) {
            return rectangleArea();
        } else if (type == FigureType.CIRCLE) {
            return circleArea();
        }
        return -1;
    }

    public double perimeter() {
        if (type == FigureType.RECTANGLE) {
            return rectanglePerimeter();
        } else if (type == FigureType.CIRCLE) {
            return circlePerimeter();
        }
        return -1;
    }

    public double circlePerimeter() {
        return 2 * Math.PI * radius;
    }

    public double rectanglePerimeter() {
        return 2 * (width + height);
    }

    public double rectangleArea() {
        return width * height;
    }

    public double circleArea() {
        return Math.PI * radius * radius;
    }

    public static Figure ofRectangle(double width, double height){
        return new Figure(width, height);
    }

    public static Figure ofCircle(double radius){
        return new Figure(radius);
    }

    public FigureType getType(){
        return this.type;
    }

    @Override
    public String toString() {
        if (type == FigureType.RECTANGLE) {
            return String.format("Figure width is %.2f\nFigure height is %.2f\nFigure area is %.2f\nFigure perimeter is %.2f", width, height, area(), perimeter());
        } else if (type == FigureType.CIRCLE) {
            return String.format("Figure radius is %.2f\nFigure area is %.2f\nFigure perimeter is %.2f", radius, area(), perimeter());
        }
        return super.toString();
    }
}
