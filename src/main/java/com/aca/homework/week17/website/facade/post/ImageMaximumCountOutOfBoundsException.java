package com.aca.homework.week17.website.facade.post;

public class ImageMaximumCountOutOfBoundsException extends RuntimeException{
    public ImageMaximumCountOutOfBoundsException(int size, int maximumSize) {
        super(String.format(
                "maximum number of images a post can have - %d, actual number of images - %d",
                maximumSize,
                size)
        );
    }
}
