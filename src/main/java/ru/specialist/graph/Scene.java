package ru.specialist.graph;

import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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
//    @PreDestroy
//    public void close (){
//        ls.forEach(obj-> obj.erase());

    /// /        System.out.println("scene close");
//    }
    public void erase() {
        ls.forEach(obj -> obj.erase());
    }
}
