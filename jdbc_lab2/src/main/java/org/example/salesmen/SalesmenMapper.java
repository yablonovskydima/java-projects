package org.example.salesmen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Function;

public class SalesmenMapper implements Function<ResultSet, Salesmen>
{

    @Override
    public Salesmen apply(ResultSet resultSet)
    {
        try
        {
            int id = resultSet.getInt("Id");
            String name = resultSet.getString("Name");
            String phonenumber = resultSet.getString("PhoneNumber");
            String email = resultSet.getString("Email");
            return new Salesmen(id, name, phonenumber, email);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
