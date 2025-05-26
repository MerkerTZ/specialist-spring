package ru.specialist.building;

public class House {

    private Window window;
    private Material wall;
    private int layer;

    public House() {
    }

    public House(Window window) {
        this.window = window;
    }

    public Window getWindow() {
        return window;
    }

    public void setWindow(Window window) {
        this.window = window;
    }

    public void ventilate() {
        getWindow().open();
    }

    public Material getWall() {
        return wall;
    }

    public void setWall(Material wall) {
        this.wall = wall;
    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public void buildWall() {
        for (int i = 1; i <= getLayer(); i++) {
            System.out.println("Floor " + i);
            wall.BuildUp();
        }
    }
}
