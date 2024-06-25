package org.example.products;

import java.util.Date;

public class Products
{
    private int id;
    private String name;
    private int price;
    private String saledate;

    private int clientid;
    private int sellerid;

    public Products(int id, String name, int price, String saledate, int clientid, int sellerid) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.saledate = saledate;
        this.clientid = clientid;
        this.sellerid = sellerid;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getSaledate() {
        return  saledate;
    }

    public int getClientid() {
        return clientid;
    }

    public int getSellerid() {
        return sellerid;
    }
}
