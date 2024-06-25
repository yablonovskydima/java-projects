package org.example.vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CarRepository
{
    private final String url;
    private final String user;
    private final String pass;

    public Connection connection;

    public CarRepository(String url, String user, String pass) throws SQLException {
        this.url = url;
        this.user = user;
        this.pass = pass;
        connection = DriverManager.getConnection(url, user, pass);
    }

    public List<Car> getAllCar(Function<ResultSet, Car> mapper) throws SQLException {
        List<Car> cars = new ArrayList<>();
        String query = "SELECT * FROM car";
        PreparedStatement st = connection.prepareStatement(query);
        ResultSet rs = st.executeQuery();

        while (rs.next())
        {
            Car car = mapper.apply(rs);
            cars.add(car);
        }
        return  cars;
    }


    public List<String> getBrands(Function<ResultSet, Car> mapper) throws SQLException {
        List<String> brands = new ArrayList<>();
        String query = "SELECT * FROM car";
        PreparedStatement st = connection.prepareStatement(query);
        ResultSet rs = st.executeQuery();

        while (rs.next())
        {
            Car car = mapper.apply(rs);
            brands.add(car.getBrand());
        }
        return  brands;
    }

    public void addCar(Car car) throws SQLException {
        String query = "INSERT INTO car (Brand, Name, Engine_volume, Date, Color, Type) VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, car.getBrand());
        ps.setString(2, car.getName());
        ps.setDouble(3, car.getEngine_volume());
        ps.setInt(4, car.getDate());
        ps.setString(5, car.getColor());
        ps.setString(6, car.getType());
        ps.executeUpdate();
    }
    public List<String> getBrandCount() throws SQLException {
        List<String> res = new ArrayList<>();
        String query = """
                SELECT Brand, COUNT(*) AS Car_count
                FROM car
                GROUP BY Brand;
                """;
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            String brand = rs.getString("Brand");
            int count = rs.getInt("Car_count");
            res.add(brand + ": " + count + " cars");
        }
        return  res;
    }

    public String getBrandMax() throws SQLException {
        String res = "";
        String query = """
                SELECT Brand
                    FROM car
                    GROUP BY Brand
                    ORDER BY COUNT(*) DESC
                    LIMIT 1;
                """;
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
            res = rs.getString("Brand");
        }
        return  res;
    }

    public String getBrandMin() throws SQLException {
        String res = "";
        String query = """
                SELECT Brand
                    FROM car
                    GROUP BY Brand
                    ORDER BY COUNT(*) ASC
                    LIMIT 1;
                """;
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
            res = rs.getString("Brand");
        }
        return  res;
    }

    public List<Car> getCarByDate(Function<ResultSet, Car> mapper, int year) throws SQLException {
        List<Car> cars = new ArrayList<>();
        String query = """
                SELECT *
                    FROM car
                    WHERE Date = %d
                """.formatted(year);
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            Car car = mapper.apply(rs);
            cars.add(car);
        }

        return  cars;
    }

    public List<Car> getCarByDates(Function<ResultSet, Car> mapper, int year1, int year2) throws SQLException {
        List<Car> cars = new ArrayList<>();
        String query = """
                SELECT *
                    FROM car
                    WHERE Date > %d AND Date < %d
                """.formatted(year1, year2);
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            Car car = mapper.apply(rs);
            cars.add(car);
        }

        return  cars;
    }

    public List<Car> getCarByBrand(Function<ResultSet, Car> mapper, String brand) throws SQLException {
        List<Car> cars = new ArrayList<>();
        String query = """
                SELECT *
                    FROM car
                    WHERE Date = %s
                """.formatted(brand);
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            Car car = mapper.apply(rs);
            cars.add(car);
        }

        return  cars;
    }

    public List<Car> getCarByColor(Function<ResultSet, Car> mapper, String color) throws SQLException {
        List<Car> cars = new ArrayList<>();
        String query = """
                SELECT *
                    FROM car
                    WHERE Color = %s
                """.formatted(color);
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            Car car = mapper.apply(rs);
            cars.add(car);
        }

        return  cars;
    }

    public List<Car> getCarByType(Function<ResultSet, Car> mapper, String type) throws SQLException {
        List<Car> cars = new ArrayList<>();
        String query = """
                SELECT *
                    FROM car
                    WHERE Type = %s
                """.formatted(type);
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            Car car = mapper.apply(rs);
            cars.add(car);
        }

        return  cars;
    }

    public List<Car> getCarByVolume(Function<ResultSet, Car> mapper, Double volume) throws SQLException {
        List<Car> cars = new ArrayList<>();
        String query = """
                SELECT *
                    FROM car
                    WHERE Engine_volume = %f
                """.formatted(volume);
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            Car car = mapper.apply(rs);
            cars.add(car);
        }

        return  cars;
    }

    public void deleteRow(int Id) throws SQLException
    {
        String query = """
                 DELETE FROM car
                 WHERE Id = %d
                 """.formatted(Id);

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
    }

    public void updateRow(int Id, String newBrand, String newName, double newVolume, int newDate, String newColor, String newType) throws SQLException
    {

        String query = """
                UPDATE car 
                SET 
                Brand = ?, 
                Name = ?, 
                Engine_volume = ?, 
                Date = ?,
                Color = ?,
                Type = ?,
                WHERE Note_id = ?
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, newBrand);
        preparedStatement.setString(2, newName);
        preparedStatement.setDouble(3, newVolume);
        preparedStatement.setInt(4, newDate);
        preparedStatement.setString(5,newColor);
        preparedStatement.setString(6,newType);
        preparedStatement.setInt(7,Id);
        preparedStatement.executeUpdate();

    }

    public void  Close() throws SQLException {
        connection.close();
    }
}
