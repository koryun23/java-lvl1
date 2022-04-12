package com.aca.classwork.week7.color;

public enum ColorType {
    RED("red color", 0xFFFF0000),
    GREEN("green color"),
    BLUE("blue color", 0xFF0000FF);

    private final String colorStringRepresentation;
    private int intValue;

    ColorType(String colorStringRepresentation) {
        this.colorStringRepresentation = colorStringRepresentation;
        System.out.println("The constructor was involved " + colorStringRepresentation);
    }

    ColorType(String colorStringRepresentation, int intValue) {
        this.colorStringRepresentation = colorStringRepresentation;
        this.intValue = intValue;
        System.out.println("The constructor was involved " + colorStringRepresentation);
    }

    public String getColorStringRepresentation() {
        return colorStringRepresentation;
    }

    public int getIntValue() {
        return intValue;
    }

    @Override
    public String toString() {
        if (this == ColorType.RED) {
            return "red color";
        } else if (this == ColorType.BLUE) {
            return "blue color";
        }
        return "green color";

    }
}
