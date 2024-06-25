package com.lesson.lesson18.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Client
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z]+$")
    @Size(max = 100)
    private String name;

    @Size(max = 10)
    @NotNull
    @Pattern(regexp = "^[0-9]+$")
    private String phoneNumber;

    @OneToMany(mappedBy = "client")
    private List<Rent> rents;

    public Client() {
    }

    public Client(String name, String phoneNumber, List<Rent> rents) {
        this.name = name;
        this.phoneNumber = phoneNumber;
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

    public void setRents(List<Rent> rents) {
        this.rents = rents;
    }
}
