package org.example.city;

public class City
{
    private int id;
    private String name;
    private int population;
    private int country_id;

    public City(int id, String name, int population, int country_id) {
        this.id = id;
        this.name = name;
        this.population = population;
        this.country_id = country_id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public int getCountry_id() {
        return country_id;
    }

    @Override
    public String toString()
    {
        return "Id: " + id + ", Name: " + name + ", Population: " + population + ", Country id: " + country_id;
    }
}
