package com.aca.homework.week4.image;

public class ImageTest {
    public static void main(String[] args) {
        Image image = new Image(5, 10);
        image.draw(1, 2);
        image.draw(2, 1);
        image.draw(2, 2);
        image.draw(2, 3);
        image.draw(3, 0);
        image.draw(3, 1);
        image.draw(3, 2);
        image.draw(3, 3);
        image.draw(3, 4);
        image.draw(4, 0);
        image.draw(4, 4);
        image.draw(5, 0);
        image.draw(5, 4);
        image.draw(6, 0);
        image.draw(6, 4);
        image.draw(7, 0);
        image.draw(7, 4);
        image.draw(8, 0);
        image.draw(8, 1);
        image.draw(8, 2);
        image.draw(8, 3);
        image.draw(8, 4);

        image.show();
    }
}
