package org.example.vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Function;

public class CarMapper implements Function<ResultSet, Car>
{

    @Override
    public Car apply(ResultSet resultSet)
    {
        try
        {
            int id = resultSet.getInt("Id");
            String brand = resultSet.getString("Brand");
            String name= resultSet.getString("Name");
            double vol = resultSet.getDouble("Engine_volume");
            int date = resultSet.getInt("Date");
            String color = resultSet.getString("Color");
            String type = resultSet.getString("Type");
            return new Car(id, brand, name, vol, date, color, type);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
