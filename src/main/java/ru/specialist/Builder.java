package ru.specialist;

import java.util.Locale;

public class Builder
{
    public Window createPlasticWindow(){
        return new PlasticWindow();
    }
    public Window createWoodWindow(){
        return new WoodWindow();
    }
    public Window createWindow(){
        if(Locale.getDefault().getCountry().equals("RU"))
            return createWoodWindow();
        else
            return createPlasticWindow();
    }

    public House createHouse(){
        return new House(createWindow());
    }
}
