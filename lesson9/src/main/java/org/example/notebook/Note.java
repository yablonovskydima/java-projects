package org.example.notebook;

public class Note
{
    private int id;
    private String brand;
    private String name;
    private int pages_count;
    private String cover_type;
    private String country_producer;
    private String pages_view;

    public Note(int id, String brand, String name, int pages_count, String cover_type, String country_producer, String pages_view) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.pages_count = pages_count;
        this.cover_type = cover_type;
        this.country_producer = country_producer;
        this.pages_view = pages_view;
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

    public int getPages_count() {
        return pages_count;
    }

    public String getCover_type() {
        return cover_type;
    }

    public String getCountry_producer() {
        return country_producer;
    }

    public String getPages_view() {
        return pages_view;
    }
}
