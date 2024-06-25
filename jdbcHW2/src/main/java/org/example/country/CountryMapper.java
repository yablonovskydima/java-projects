package org.example.country;

import org.example.city.City;

import java.sql.ResultSet;
import java.util.function.Function;

public class CountryMapper  implements Function<ResultSet, Country>
{

    @Override
    public Country apply(ResultSet resultSet) {
        try
        {
            int id= resultSet.getInt("Id");
            String name = resultSet.getString("Name");
            int population = resultSet.getInt("Population");
            String capital = resultSet.getString("Capital");
            return new Country(id, name, population, capital);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
