package ru.specialist.building;

public class Brick implements Material {
    @Override
    public void BuildUp() {
        System.out.println("Build up wall using Brick");
    }
}
