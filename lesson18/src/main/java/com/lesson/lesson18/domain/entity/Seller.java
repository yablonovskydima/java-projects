package com.lesson.lesson18.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Seller
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(max=100)
    @NotNull
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String name;

    @Size(max=10)
    @NotNull
    @Pattern(regexp = "^[0-9]+$")
    private String phoneNumber;


    @OneToMany(mappedBy = "seller")
    private List<Flat> flats;

    @OneToMany(mappedBy = "seller")
    private List<Rent> rents;

    public Seller() {
    }

    public Seller(int id, String name, String phoneNumber, List<Flat> flats, List<Rent> rents) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.flats = flats;
        this.rents = rents;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<Flat> getFlats() {
        return flats;
    }

    public List<Rent> getRents() {
        return rents;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setFlats(List<Flat> flats) {
        this.flats = flats;
    }

    public void setRents(List<Rent> rents) {
        this.rents = rents;
    }
}
