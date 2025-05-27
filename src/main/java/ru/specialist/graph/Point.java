package ru.specialist.graph;

import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("myPoint")
//@Scope("prototype")
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

//    @Value("${point.x}")
    public void setX(int x) {
        coords.setX(x);
    }

    public int getY() {
        return coords.getY();
    }

//    @Value("${point.y}")
    public void setY(int y) {
        coords.setX(y);
    }

//    @Value("${point.color}")
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

    @PreDestroy
    public void close (){
        System.out.println("Destroy point");
    }
}
