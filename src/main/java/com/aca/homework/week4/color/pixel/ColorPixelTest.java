package com.aca.homework.week4.color.pixel;


public class ColorPixelTest {
    public static void main(String[] args) {
        ColorPixel pixel1 = new ColorPixel(1, 2, "red");
        ColorPixel pixel2 = new ColorPixel(2, 1, "red");
        ColorPixel pixel3 = new ColorPixel(3, 3, "blue");
        ColorPixel[] pixels = {pixel1, pixel2, pixel3};
        for (ColorPixel pixel : pixels){
            System.out.println("The x coordinate of current pixel: " + pixel.getX());
            System.out.println("The y coordinate of current pixel: " + pixel.getY());
            System.out.println("The color of the current pixel: " + pixel.getColor());
            System.out.println("-------------------------------------------");
        }

    }
}
