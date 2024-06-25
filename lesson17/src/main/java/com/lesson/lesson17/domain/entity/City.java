package com.lesson.lesson17.domain.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "city")
public class City
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int peopleCount;
    private String briefHistory;
    private String coordinates;


    public City() {
    }

    public City(int id, String name, int peopleCount, String briefHistory, String coordinates) {
        this.id = id;
        this.name = name;
        this.peopleCount = peopleCount;
        this.briefHistory = briefHistory;
        this.coordinates = coordinates;
    }

    public int getId() {
        return id;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public String getName() {
        return name;
    }

    public String getBriefHistory() {
        return briefHistory;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBriefHistory(String briefHistory) {
        this.briefHistory = briefHistory;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }
}
