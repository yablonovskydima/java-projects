package org.example.clients;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Function;

public class ClientMapper implements Function<ResultSet, Client>
{

    @Override
    public Client apply(ResultSet resultSet) {
        try
        {
            int id = resultSet.getInt("Id");
            String name = resultSet.getString("Name");
            String phonenumber = resultSet.getString("PhoneNumber");
            String email = resultSet.getString("Email");
            return new Client(id, name, phonenumber, email);

        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
