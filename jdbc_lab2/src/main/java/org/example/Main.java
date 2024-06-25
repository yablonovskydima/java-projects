package org.example;

import org.example.clients.Client;
import org.example.clients.ClientMapper;
import org.example.clients.ClientRepository;
import org.example.products.ProductsRepository;
import org.example.products.Products;
import org.example.products.ProductsMapper;
import org.example.salesmen.Salesmen;
import org.example.salesmen.SalesmenMapper;
import org.example.salesmen.SalesmenRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main
{
    private static String connectionString = "jdbc:mysql://localhost:3306/sales";
    private static String user = "root";
    private static String pass = "";
    public static void main(String[] args) throws SQLException, ParseException {

        DBconnection DBconnection = new DBconnection(connectionString, user, pass);
        Connection connection = DBconnection.getConnection();

        ClientRepository c_repository = new ClientRepository(connection);
        ClientMapper clientMapper = new ClientMapper();

        SalesmenRepository s_repository = new SalesmenRepository(connection);
        SalesmenMapper salesmenMapper = new SalesmenMapper();

        ProductsRepository p_repository = new ProductsRepository(connection);
        ProductsMapper productsMapper = new ProductsMapper();

        /*c_repository.addClient(new Client(1, "Alex", "0985149388", "yipiyapi228@gmail.com"));
        c_repository.addClient(new Client(2, "Petro", "0985564328", "yipiyapi336@gmail.com"));

        s_repository.addSeller(new Salesmen(1, "Vasya", "0987454515", "someseller@gmail.com"));
        s_repository.addSeller(new Salesmen(2, "Stepan", "0987454515", "someseller@gmail.com"));

        p_repository.addProduct(new Products(1, "Milk", 40, "31-12-2022", 2, 1));*/

        List<Client> allC = c_repository.getAllClients(clientMapper);
        List<Salesmen> allS = s_repository.getAllSellers(salesmenMapper);
        List<Products> allP = p_repository.getAllProducts(productsMapper);

        List<String> res = s_repository.succesfulSeller();

        for (var i:allC)
        {
            System.out.println("Id " + i.getId() + " Name " + i.getName());
        }

        System.out.println("\n");
        for (var i: allS)
        {
            System.out.println("Id " + i.getId() + " Name " + i.getName());
        }

        System.out.println("\n");
        for (var i: allP)
        {
            System.out.println("Id " + i.getId() + " Name " + i.getName());
        }

        for (var i: res)
        {
            System.out.println(i);
        }

        System.out.println(p_repository.Popular());

        DBconnection.Close();

    }
}