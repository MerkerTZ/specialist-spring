package ru.specialist;

import org.springframework.stereotype.Component;

@Component
public class WoodWindow implements Window {

    public void open() {
        System.out.println("Wood window open");
    }
}