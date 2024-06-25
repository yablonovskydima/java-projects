package com.lesson.lesson18.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Rent
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Pattern(regexp = "^[0-9]+$")
    private int price;
    @NotNull

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date startDate;
    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Future
    private Date endDate;

    @ManyToOne
    @NotNull
    private Client client;
    @ManyToOne
    @NotNull
    private Seller seller;


    public Rent() {
    }

    public Rent(int id, int price, Date startDate, Date endDate, Client client, Seller seller) {
        this.id = id;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.client = client;
        this.seller = seller;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Client getClient() {
        return client;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}


