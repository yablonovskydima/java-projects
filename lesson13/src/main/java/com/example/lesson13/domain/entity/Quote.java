package com.example.lesson13.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class Quote
{
    private String message;
    private String author;

    private String cateory;
    public static List<Quote> quotes = new ArrayList<>();

    public Quote(String message, String author, String cateory) {
        this.message = message;
        this.author = author;
        this.cateory = cateory;
    }


    public String getCateory() {
        return cateory;
    }

    public String getMessage() {
        return message;
    }

    public String getAuthor() {
        return author;
    }

    static
    {
        quotes.add(new Quote("You can teach a student a lesson for a day; but if you can teach him to learn by creating curiosity, he will continue the learning process as long as he lives.", "Clay P. Bedford", "Education"));
        quotes.add(new Quote("Success is not final; failure is not fatal: it is the courage to continue that counts.", "Winston Churchill", "Business"));
        quotes.add(new Quote("As he read, I fell in love the way you fall asleep: slowly, and then all at once.", "John Green", "Love"));
    }

    @Override
    public String toString()
    {
        return getMessage() + "\nAuthor: " + getAuthor() + "\nCategory: " + getCateory();
    }
}

