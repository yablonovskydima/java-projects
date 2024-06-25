package org.example.country;

public class Country
{
    private int id;
    private String name;
    private int population;
    private String capital;

    public Country(int id, String name, int population, String capital) {
        this.id = id;
        this.name = name;
        this.population = population;
        this.capital = capital;
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

    public String getCapital() {
        return capital;
    }

    @Override
    public String toString()
    {
        return "Id: " + id + ", Name: " + name + ", Population: " + population + ", Capital: " + capital;
    }
}
