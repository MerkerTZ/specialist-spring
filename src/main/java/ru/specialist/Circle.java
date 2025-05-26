package ru.specialist;

public class Circle extends Shape{
    private Coords center;
    private int radius;

    public Circle(Coords center) {
        this(center, 0);
    }
    public Circle(Coords center, int radius){
        this.center = center;
        setRadius(radius);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getX() {
        return center.getX();
    }

    public void setX(int x) {
        center.setX(x);
    }

    public int getY() {
        return center.getY();
    }

    public void setY(int y) {
        center.setX(y);
    }

    @Override
    public void draw() {
        System.out.printf("Circle %s Radius: %d Color: %s\n", center.toString(), getRadius(), getColor());
    }
}
