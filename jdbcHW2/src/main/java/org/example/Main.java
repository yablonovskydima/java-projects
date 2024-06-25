package org.example;

import org.example.city.City;
import org.example.city.CityMapper;
import org.example.city.CityRepository;
import org.example.country.Country;
import org.example.country.CountryMapper;
import org.example.country.CountryRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static String connectionString = "jdbc:mysql://localhost:3306/countries";
    private static String user = "root";
    private static String pass = "";
    public static void main(String[] args) throws SQLException
    {
        DBConnection dbConnection = new DBConnection(connectionString, user, pass);
        Connection connection = dbConnection.getConnection();

        CityRepository cityRepository = new CityRepository(connection);
        CityMapper cityMapper = new CityMapper();

        CountryRepository countryRepository = new CountryRepository(connection);
        CountryMapper countryMapper = new CountryMapper();

        /*cityRepository.addCity(new City(1, "Kyiv", 2000000, 1));
        cityRepository.addCity(new City(2, "New York", 5000000, 2));
        cityRepository.addCity(new City(3, "Los Angeles", 7000000, 2));
        countryRepository.addCountry(new Country(1, "Ukraine", 43000000, "Kyiv"));
        countryRepository.addCountry(new Country(2, "USA", 150000000, "Washington DC"));
        cityRepository.addCity(new City(1, "Ivano-Frankivsk", 200000, 1));*/

        List<City> allcities = cityRepository.getAllCities(cityMapper);
        List<Country> allcountries = countryRepository.getAllCountries(countryMapper);
        String avg = cityRepository.getAveragePopulation(2);

        System.out.println("Cities: ");
        for (var i :allcities)
        {
            System.out.println(i.toString());
        }
        System.out.println("Countries: ");
        for (var i :allcountries)
        {
            System.out.println(i.toString());
        }
        System.out.println(avg);

        List<City> citiesUkraine = cityRepository.getCityByCountry(cityMapper, 1);
        for (var i :citiesUkraine)
        {
            System.out.println(i.toString());
        }
    }
}