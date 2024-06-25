package org.example.country;

import org.example.city.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CountryRepository
{
    public Connection connection;

    public CountryRepository(Connection connection) throws SQLException {

        this.connection = connection;
    }

    public List<Country> getAllCountries(Function<ResultSet, Country> mapper) throws SQLException {
        List<Country> countries = new ArrayList<>();
        String query = "SELECT * FROM country";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next())
        {
            Country country = mapper.apply(rs);
            countries.add(country);
        }

        return countries;
    }

    public void addCountry(Country country) throws SQLException {
        String query = "INSERT INTO country (Name, Population, Capital) VALUES(?,  ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, country.getName());
        statement.setInt(2, country.getPopulation());
        statement.setString(3, country.getCapital());
        statement.executeUpdate();
    }

    public String getCapital(String country) throws SQLException {
        String res = "";
        String query = "SELECT Capital FROM country WHERE Name = %s".formatted(country);
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        if(resultSet.next())
        {
            res = resultSet.getString("Capital") + " - country: " + resultSet.getString("Name");
        }
        return res;
    }

    public List<Country> getTop3CountriesByCities(Function<ResultSet, Country> mapper) throws SQLException {
        List<Country> countries = new ArrayList<>();
        String query = """
                SELECT *, COUNT(m.Id) as City_count FROM country c
                LEFT JOIN city m ON c.Id = m.Country_id
                GROUP BY c.Id, c.Name
                ORDER BY City_count DESC
                LIMIT 3
                """;

        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next())
        {
            Country c = mapper.apply(rs);
            countries.add(c);
        }
        return countries;
    }

    public List<Country> getTop3CountriesByPopulation(Function<ResultSet, Country> mapper) throws SQLException {
        List<Country> countries = new ArrayList<>();
        String query = """
                SELECT Name, Population FROM country
                ORDER BY Population DESC
                LIMIT 3
                """;

        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next())
        {
            Country c = mapper.apply(rs);
            countries.add(c);
        }
        return countries;
    }

    public List<Country> getTopLast3CountriesByPopulation(Function<ResultSet, Country> mapper) throws SQLException {
        List<Country> countries = new ArrayList<>();
        String query = """
                SELECT Name, Population FROM country
                ORDER BY Population ASC
                LIMIT 3
                """;

        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next())
        {
            Country c = mapper.apply(rs);
            countries.add(c);
        }
        return countries;
    }

    public List<Country> getCitiesInRange(Function<ResultSet, Country> mapper, int bound1, int bound2) throws SQLException {
        List<Country> countries = new ArrayList<>();
        String query = """
                SELECT * FROM country
                LEFT JOIN city ON country.Id = city.Id
                GROUP BY country.Id, country.Name
                HAVING COUNT(city.Id) >= %d AND COUNT(city.Id) <= %d
                """.formatted(bound1, bound2);

        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();

        while(rs.next())
        {
            Country c = mapper.apply(rs);
            countries.add(c);
        }
        return countries;
    }

    public void updateRow(int Id, String newName, int newPopulation, String newCapital) throws SQLException
    {

        String query = """
                UPDATE country 
                SET 
                Name = ?, 
                Population = ?, 
                Capital = ?,
                WHERE Id = ?
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, newName);
        preparedStatement.setInt(2, newPopulation);
        preparedStatement.setString(3, newCapital);
        preparedStatement.setInt(4, Id);
        preparedStatement.executeUpdate();

    }

    public void deleteRow(int Id) throws SQLException
    {
        String query = """
                 DELETE FROM country
                 WHERE Id = %d
                 """.formatted(Id);

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
    }

    public void Close() throws SQLException {
        connection.close();
    }

}
