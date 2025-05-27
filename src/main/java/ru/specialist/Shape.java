package ru.specialist;

public abstract class Shape {
    public abstract void draw();

    public static final String DEFAULT_COLOR = "black";
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Shape(String color) {
        this.color = color;
    }

    public Shape() {
        this.color = DEFAULT_COLOR;
    }
}
