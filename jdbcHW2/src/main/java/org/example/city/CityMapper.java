package org.example.city;

import java.sql.ResultSet;
import java.util.function.Function;

public class CityMapper implements Function<ResultSet, City>
{

    @Override
    public City apply(ResultSet resultSet) {
        try
        {
            int id= resultSet.getInt("Id");
            String name = resultSet.getString("Name");
            int population = resultSet.getInt("Population");
            int country_id = resultSet.getInt("Country_id");
            return new City(id, name, population, country_id);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
