package org.example.clients;

public class Client
{
    private int id;
    private String name;
    private String phonenumber;
    private String email;

    public Client(int id, String name, String phonenumber, String email) {
        this.id = id;
        this.name = name;
        this.phonenumber = phonenumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getEmail() {
        return email;
    }

}
