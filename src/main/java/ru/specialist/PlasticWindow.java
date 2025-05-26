package ru.specialist;

import org.springframework.stereotype.Component;

@Component
public class PlasticWindow implements Window {

    public void open() {
        System.out.println("Plastic window open");
    }
}