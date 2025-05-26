package ru.specialist;

public class App {

    public static void main (String[] args){
//        House house = new House();
//        PlasticWindow window1 = new PlasticWindow();
//        WoodWindow window2 = new WoodWindow();
//
//        house.setWindow(window1);
//        house.ventilate();
    new Builder().createHouse().ventilate();
    }
}