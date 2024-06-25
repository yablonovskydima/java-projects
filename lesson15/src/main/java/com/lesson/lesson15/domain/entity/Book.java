package com.lesson.lesson15.domain.entity;

public class Book
{
    public String id;
    private String name;
    private String description;
    private String author;
    private int pagesCount;
    private String coverType;
    private int price;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Book(String id, String name, String description, String author, int pagesCount, String coverType, int price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.author = author;
        this.pagesCount = pagesCount;
        this.coverType = coverType;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public String getCoverType() {
        return coverType;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }

    public void setCoverType(String coverType) {
        this.coverType = coverType;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
