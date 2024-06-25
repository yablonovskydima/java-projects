package org.example;

public class Gadget
{
    private String name;
    private int year;
    private int price;
    private String color;
    private String type;

    public Gadget(String name, int year, int price, String color, String type) {
        this.name = name;
        this.year = year;
        this.price = price;
        this.color = color;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }
}
