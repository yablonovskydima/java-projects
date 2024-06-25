package org.example.notebook;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Function;

public class NoteMapper implements Function<ResultSet, Note>
{
    @Override
    public Note apply(ResultSet resultSet)
    {
        try {
            int id = resultSet.getInt("Note_id");
            String brand = resultSet.getString("Brand");
            String name = resultSet.getString("Notebook_name");
            int pages_count = resultSet.getInt("Pages_count");
            String cover_type = resultSet.getString("Cover_type");
            String country_producer = resultSet.getString("Country_producer");
            String pages_view = resultSet.getString("Pages_view");
            return new Note(id, brand, name, pages_count, cover_type, country_producer, pages_view);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
