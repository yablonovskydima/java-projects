package org.example.vehicle;

import java.lang.reflect.Type;

public class Car
{
    private int id;
    private String brand;
    private String name;
    private double engine_volume;
    private int date;
    private String color;
    private String type;

    public Car(int id, String brand, String name, double engine_volume, int date, String color, String type) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.engine_volume = engine_volume;
        this.date = date;
        this.color = color;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public double getEngine_volume() {
        return engine_volume;
    }

    public int getDate() {
        return date;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }
}
