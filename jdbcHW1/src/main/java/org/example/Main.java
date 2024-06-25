package org.example;

import org.example.vehicle.Car;
import org.example.vehicle.CarMapper;
import org.example.vehicle.CarRepository;

import java.sql.SQLException;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static String connectionString = "jdbc:mysql://localhost:3306/vehicle";
    private static String user = "root";
    private static String pass = "";
    public static void main(String[] args) throws SQLException {

        CarRepository repository = new CarRepository(connectionString, user, pass);
        CarMapper mapper = new CarMapper();
        List<Car> allcars = repository.getAllCar(mapper);

        repository.addCar(new Car(1, "Nissan" , "s14" , 2.4 , 1999, "Yellow", "sportcar"));
        repository.addCar(new Car(2, "Renault" , "scenic" , 1.0 , 2006 , "Grey","minivan"));
        repository.addCar(new Car(3, "Mercedes" , "Maybach" , 4.0 , 2013 , "Black","crossover"));

        for (var i:allcars)
        {
            System.out.println("Id: " + i.getId() + " brand: " + i.getBrand() + " name: " + i.getName() + " engine volume: " + i.getEngine_volume() + " date of issue: " + i.getDate() + " color: "+i.getColor() + " type: " + i.getType());
        }

    }
}