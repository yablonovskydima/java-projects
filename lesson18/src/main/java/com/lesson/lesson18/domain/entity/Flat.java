package com.lesson.lesson18.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Flat
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(max = 150)
    private String address;

    @NotNull
    @ManyToOne
    private Seller seller;

    public Flat() {
    }

    public Flat(int id, String address, Seller seller) {
        this.id = id;
        this.address = address;
        this.seller = seller;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
