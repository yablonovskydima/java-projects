package org.example;

public class Projector
{
    private String name;
    private int year;
    private int price;
    private  String producer;

    public Projector(String name, int year, int price, String producer) {
        this.name = name;
        this.year = year;
        this.price = price;
        this.producer = producer;
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

    public String getProducer() {
        return producer;
    }
}
