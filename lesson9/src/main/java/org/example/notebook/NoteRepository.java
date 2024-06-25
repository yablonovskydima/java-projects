package org.example.notebook;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class NoteRepository
{
    private final String url;
    private final  String user;
    private final String pass;
    public  Connection connection;

    public NoteRepository(String url, String user, String pass) throws SQLException {
        this.url = url;
        this.user = user;
        this.pass = pass;
        connection = DriverManager.getConnection(url, user, pass);
    }

    public List<Note> getAllNotes(Function<ResultSet, Note> mapper) throws SQLException {
        List<Note> notes = new ArrayList<>();
        String query = "SELECT * FROM note";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next())
        {
            Note note = mapper.apply(rs);
            notes.add(note);
        }

        return notes;
    }

    public void addNote(Note note) throws SQLException {
        String query = "INSERT INTO note (Brand, Notebook_name, Pages_count, Cover_type, Country_producer, Pages_view) VALUES(?, ?,  ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, note.getBrand());
        statement.setString(2, note.getName());
        statement.setInt(3, note.getPages_count());
        statement.setString(4, note.getCover_type());
        statement.setString(5, note.getCountry_producer());
        statement.setString(6, note.getPages_view());
        statement.executeUpdate();
    }

    public List<String> getCountries(Function<ResultSet, Note> mapper) throws SQLException {
        List<String> countries = new ArrayList<>();
        String query = "SELECT * FROM note";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next())
        {
            Note note = mapper.apply(rs);
            countries.add(note.getCountry_producer());
        }

        return countries;
    }


    public List<String> getNotesByCountry() throws SQLException {
        List<String> res = new ArrayList<>();
        String query = """
                SELECT Country_producer, COUNT(*) AS Notebook_number
               FROM note
               GROUP BY Country_producer
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next())
        {
            String country = rs.getString("Country_producer");
            int count = rs.getInt("Notebook_number");
            res.add(country + ": " + count + " notes");
        }

        return res;
    }


    public List<String> getNotebooksByBrand() throws SQLException {
        List<String> result = new ArrayList<>();
        String query = "SELECT Brand, COUNT(*) AS Notebook_number FROM note GROUP BY Brand";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String brand = resultSet.getString("Brand");
            int count = resultSet.getInt("Notebook_number");
            result.add(brand + ": " + count + " notebooks");
        }

        return result;
    }

    public String getCountryWithMostNotebooks() throws SQLException {
        String result = "";

        String query = """
                SELECT Country_producer
                FROM note
                GROUP BY Country_producer
                ORDER BY COUNT(*) DESC 
                LIMIT 1""";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            result = resultSet.getString("Country_producer");
        }
        return result;
    }



    public String getCountryWithLeastNotebooks() throws SQLException {
        String result = "";
        String query = """
                    SELECT Country_producer 
                    FROM note 
                    GROUP BY Country_producer 
                    ORDER BY COUNT(*) ASC 
                    LIMIT 1""";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            result = resultSet.getString("Country_producer");
        }

        return result;
    }


    public String getBrandWithMostNotebooks() throws SQLException {
        String result = "";
        String query = """
                    SELECT Brand 
                    FROM note 
                    GROUP BY Brand 
                    ORDER BY COUNT(*) DESC 
                    LIMIT 1""";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            result = resultSet.getString("Brand");
        }

        return result;
    }

    public String getBrandWithLeastNotebooks() throws SQLException {
        String result = "";
        String query = """
                    SELECT Brand
                    FROM note
                    GROUP BY Brand 
                    ORDER BY COUNT(*) ASC 
                    LIMIT 1""";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            result = resultSet.getString("Brand");
        }

        return result;
    }

    public List<Note> getNotebooksWithHardCover() throws SQLException {
        List<Note> notebooks = new ArrayList<>();

        String query = "SELECT * FROM notebooks WHERE Cover_type = 'Hard'";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("Note_id");
            String name = resultSet.getString("Notebook_name");
            String brand = resultSet.getString("Brand");
            String country_producer = resultSet.getString("Country_producer");
            int pagesnum = resultSet.getInt("Pages_count");
            String cover_type = resultSet.getString("Cover_type");
            String pages_view= resultSet.getString("Pages_view");
            notebooks.add(new Note(id, brand, name, pagesnum, cover_type, country_producer, pages_view));
        }

        return notebooks;
    }

    public List<Note> getNotebooksWithSoftCover() throws SQLException {
        List<Note> notebooks = new ArrayList<>();

        String query = "SELECT * FROM notebooks WHERE Cover_type = 'Soft'";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("Note_id");
            String name = resultSet.getString("Notebook_name");
            String brand = resultSet.getString("Brand");
            String country_producer = resultSet.getString("Country_producer");
            int pagesnum = resultSet.getInt("Pages_count");
            String cover_type = resultSet.getString("Cover_type");
            String pages_view= resultSet.getString("Pages_view");
            notebooks.add(new Note(id, brand, name, pagesnum, cover_type, country_producer, pages_view));
        }

        return notebooks;
    }

    public List<Note> getNotebooksSpecificCountry(String country) throws SQLException {
        List<Note> notebooks = new ArrayList<>();

        String query = String.format("""
                SELECT * FROM note
                WHERE Country_producer = "%s"
                """, country);
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("Note_id");
            String name = resultSet.getString("Notebook_name");
            String brand = resultSet.getString("Brand");
            String country_producer = resultSet.getString("Country_producer");
            int pagesnum = resultSet.getInt("Pages_count");
            String cover_type = resultSet.getString("Cover_type");
            String pages_view= resultSet.getString("Pages_view");
            notebooks.add(new Note(id, brand, name, pagesnum, cover_type, country_producer, pages_view));
        }

        return notebooks;
    }

    public List<Note> getNotebooksSpecificView(String view) throws SQLException {
        List<Note> notebooks = new ArrayList<>();

        String query = String.format("""
                SELECT * FROM note
                WHERE Pages_view = "%s"
                """, view);
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("Note_id");
            String name = resultSet.getString("Notebook_name");
            String brand = resultSet.getString("Brand");
            String country_producer = resultSet.getString("Country_producer");
            int pagesnum = resultSet.getInt("Pages_count");
            String cover_type = resultSet.getString("Cover_type");
            String pages_view= resultSet.getString("Pages_view");
            notebooks.add(new Note(id, brand, name, pagesnum, cover_type, country_producer, pages_view));
        }

        return notebooks;
    }

    public List<Note> getNotebooksSpecificView(int view) throws SQLException {
        List<Note> notebooks = new ArrayList<>();

        String query = String.format("""
                SELECT * FROM note
                WHERE Pages_view = "%s"
                """, view);
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("Note_id");
            String name = resultSet.getString("Notebook_name");
            String brand = resultSet.getString("Brand");
            String country_producer = resultSet.getString("Country_producer");
            int pagesnum = resultSet.getInt("Pages_count");
            String cover_type = resultSet.getString("Cover_type");
            String pages_view= resultSet.getString("Pages_view");
            notebooks.add(new Note(id, brand, name, pagesnum, cover_type, country_producer, pages_view));
        }

        return notebooks;
    }

    public List<Note> getNotebooksSpecificPagesCount(int count) throws SQLException {
        List<Note> notebooks = new ArrayList<>();

        String query = String.format("""
                SELECT * FROM note
                WHERE Pages_count > "%d"
                """, count);
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("Note_id");
            String name = resultSet.getString("Notebook_name");
            String brand = resultSet.getString("Brand");
            String country_producer = resultSet.getString("Country_producer");
            int pagesnum = resultSet.getInt("Pages_count");
            String cover_type = resultSet.getString("Cover_type");
            String pages_view = resultSet.getString("Pages_view");
            notebooks.add(new Note(id, brand, name, pagesnum, cover_type, country_producer, pages_view));
        }

        return notebooks;
    }

    public void updateRow(int Id, String newName, String newBrand, String newCountry_producer, int newNumberOfPages, String newCover_type, String newPages_view) throws SQLException
    {

        String query = """
                UPDATE note 
                SET 
                Brand = ?, 
                Notebook_name = ?, 
                Pages_count = ?, 
                Cover_type = ?,
                Country_producer = ?,
                Pages_view = ?,
                WHERE Note_id = ?
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, newBrand);
        preparedStatement.setString(2, newName);
        preparedStatement.setInt(3, newNumberOfPages);
        preparedStatement.setString(4, newCover_type);
        preparedStatement.setString(5,newCountry_producer);
        preparedStatement.setString(6,newPages_view);
        preparedStatement.setInt(7,Id);
        preparedStatement.executeUpdate();

    }

    public void deleteRow(int Id) throws SQLException
    {
         String query = """
                 DELETE FROM note
                 WHERE Note_id = %d
                 """.formatted(Id);

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
    }
    public void Close() throws SQLException
    {
        connection.close();
    }


}
