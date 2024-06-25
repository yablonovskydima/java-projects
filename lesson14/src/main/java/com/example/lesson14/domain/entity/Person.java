package com.example.lesson14.domain.entity;

public class Person
{
    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private String blog;
    private String notes;


    public Person(String name, String phoneNumber, String email, String blog, String notes) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.blog = blog;
        this.notes = notes;
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

    public String getEmail() {
        return email;
    }

    public String getBlog() {
        return blog;
    }

    public String getNotes() {
        return notes;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString()
    {
        return "Name: " + getName() +"\n Phone number: " + getPhoneNumber() + "\n Email: " + getEmail() + "\nBlog link: " + getBlog() + "\nNotes: " + getNotes();
    }
}
