package ru.specialist.graph;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Scene {
    private List<Shape> ls;

//    @Autowired
    public Scene(@Value("#{{myPoint, myPoint, myCircle}}") List<Shape> ls) {
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
