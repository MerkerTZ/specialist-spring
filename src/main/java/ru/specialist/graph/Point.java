package ru.specialist.graph;


public class Point extends Shape {
    private Coords coords;

    public Coords getCoords() {
        return coords;
    }

    public void setCoords(Coords coords) {
        this.coords = coords;
    }

    public Point(Coords coords) {
        this.coords = coords;
    }

    public int getX() {
        return coords.getX();
    }

    public void setX(int x) {
        coords.setX(x);
    }

    public int getY() {
        return coords.getY();
    }

    public void setY(int y) {
        coords.setX(y);
    }

    @Override
    public void setColor(String color) {
        super.setColor(color);
    }

    @Override
    public void draw() {
        System.out.printf("Point %s Color: %s  Hash: %d\n", coords, getColor(), coords.hashCode());
    }

    @Override
    public void erase() {
        System.out.printf("Erase - Point %s Color: %s\n", coords, getColor());
    }

}
