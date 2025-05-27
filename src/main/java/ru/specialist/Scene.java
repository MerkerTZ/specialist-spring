package ru.specialist;

import java.util.List;


public class Scene {
    private List<Shape> ls;

    public Scene(List<Shape> ls) {
        this.ls = ls;

    }

    public List<Shape> getLs() {
        return ls;
    }

    public void setLs(List<Shape> ls) {
        this.ls = ls;
    }

    public void draw() {
        for (var obj : getLs()) {
            obj.draw();
        }
    }
}
