package org.example;
import org.example.notebook.Note;
import org.example.notebook.NoteMapper;
import org.example.notebook.NoteRepository;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static String connectionString = "jdbc:mysql://localhost:3306/notebook";
    private static String user = "root";
    private static String pass = "";
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        NoteRepository repository = new NoteRepository(connectionString, user, pass);
        NoteMapper mapper = new NoteMapper();
        List<Note> allnotes = repository.getAllNotes(mapper);
        List<String> countries = repository.getCountries(mapper);
        List<String> notesbycountry = repository.getNotesByCountry();

        for (Note i:allnotes)
        {
            System.out.println("Id " + i.getId() + " name " + i.getName());
        }
        System.out.println("\n");
        for (String i:countries)
        {
            System.out.println(i);
        }
        for (String i:notesbycountry)
        {
            System.out.println(i);
        }
    }
}