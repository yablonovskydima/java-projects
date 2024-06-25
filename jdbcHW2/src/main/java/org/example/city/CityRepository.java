package org.example.city;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CityRepository
{
    public Connection connection;

    public CityRepository(Connection connection)throws SQLException
    {
        this.connection = connection;
    }

    public List<City> getAllCities(Function<ResultSet, City> mapper) throws SQLException {
        List<City> cities = new ArrayList<>();
        String query = "SELECT * FROM city";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next())
        {
            City city = mapper.apply(rs);
            cities.add(city);
        }

        return cities;
    }

    public void addCity(City city) throws SQLException {
        String query = "INSERT INTO city (Name, Population, Country_id) VALUES(?,  ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, city.getName());
        statement.setInt(2, city.getPopulation());
        statement.setInt(3, city.getCountry_id());
        statement.executeUpdate();
    }

    public List<City> getCityByCountry(Function<ResultSet, City> mapper, int country_id) throws SQLException {
        List<City> cities = new ArrayList<>();
        String query = """
                SELECT * FROM city
                WHERE Country_id = %d
                """.formatted(country_id);
        PreparedStatement st = connection.prepareStatement(query);
        ResultSet resultSet = st.executeQuery();
        while (resultSet.next())
        {
            City c = mapper.apply(resultSet);
            cities.add(c);
        }

        return cities;
    }

    public String getAveragePopulation(int country_id) throws SQLException {
        String res = "";
        String query = """
                SELECT AVG(Population) as Average_p FROM city
                WHERE Country_id = %d
                """.formatted(country_id);
        PreparedStatement st = connection.prepareStatement(query);
        ResultSet resultSet = st.executeQuery();
        if(resultSet.next())
        {
            res = "Average population of cities of country " + country_id +" is " +String.valueOf(resultSet.getInt("Average_p"));
        }
        return res;
    }

    public List<City> getNotUniqueCities(Function<ResultSet, City> mapper) throws SQLException {
        List<City> cities = new ArrayList<>();
        String query = """
                SELECT * FROM city
                GROUP BY Name
                HAVING COUNT(*) > 1 AND COUNT(DISTINCT Country_id) > 1
                """;
        PreparedStatement st = connection.prepareStatement(query);
        ResultSet resultSet = st.executeQuery();
        while (resultSet.next())
        {
            City city = mapper.apply(resultSet);
            cities.add(city);
        }
        return  cities;

    }

    public List<City> getUniqueCities(Function<ResultSet, City> mapper) throws SQLException {
        List<City> cities = new ArrayList<>();
        String query = """
                SELECT DISTINCT *
                FROM city
                GROUP BY Name
                HAVING COUNT(DISTINCT Country_id) > 1;
                """;
        PreparedStatement st = connection.prepareStatement(query);
        ResultSet resultSet = st.executeQuery();
        while (resultSet.next())
        {
            City city = mapper.apply(resultSet);
            cities.add(city);
        }
        return  cities;

    }

    public void updateRow(int Id, String newName, int newPopulation, int newCountry) throws SQLException
    {

        String query = """
                UPDATE city 
                SET 
                Name = ?, 
                Population = ?, 
                Country_id = ?,
                WHERE Id = ?
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, newName);
        preparedStatement.setInt(2, newPopulation);
        preparedStatement.setInt(3, newCountry);
        preparedStatement.setInt(4, Id);
        preparedStatement.executeUpdate();

    }

    public void deleteRow(int Id) throws SQLException
    {
        String query = """
                 DELETE FROM city
                 WHERE Id = %d
                 """.formatted(Id);

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
    }

    public void Close() throws SQLException {
        connection.close();
    }


}

