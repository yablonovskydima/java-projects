package org.example.products;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ProductsRepository
{

    public Connection connection;

    public ProductsRepository(Connection connection) throws SQLException {

        this.connection = connection;
    }

    public List<Products> getAllProducts(Function<ResultSet, Products> mapper) throws SQLException {
        List<Products> products = new ArrayList<>();
        String query = "SELECT * FROM products";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next())
        {
            Products product = mapper.apply(rs);
            products.add(product);
        }

        return products;
    }

    public void addProduct(Products products) throws SQLException {
        String query = "INSERT INTO products (Name, Price, Sale_date, Client_id, Seller_id) VALUES(?,  ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, products.getName());
        statement.setInt(2, products.getPrice());
        statement.setString(3, products.getSaledate());
        statement.setInt(4, products.getClientid());
        statement.setInt(5, products.getSellerid());
        statement.executeUpdate();
    }

    public List<String> getProductsbyDate(String date) throws SQLException
    {
        List<String> res= new ArrayList<>();
        String query = "SELECT * FROM products WHERE STR_TO_DATE('Sale_date', '%d-%m-%Y') = STR_TO_DATE("+date+", '%d-%m-%Y')";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        while (rs.next())
        {
            int id = rs.getInt("Id");
            String name = rs.getString("Name");
            int price = rs.getInt("Price");
            String dt = rs.getString("Sale_date");

            res.add("Id " + id + " Name " + name + " Price " + price + " date " + dt);
        }
        return res;
    }

    public List<String> getProductsbyDateRange(String date1, String date2) throws SQLException
    {
        List<String> res= new ArrayList<>();
        String query = "SELECT * FROM products WHERE STR_TO_DATE('Sale_date', '%d-%m-%Y') >= STR_TO_DATE("+date1+", '%d-%m-%Y') AND Sale_date <= STR_TO_DATE("+date2+", '%d-%m-%Y')";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        while (rs.next())
        {
            int id = rs.getInt("Id");
            String name = rs.getString("Name");
            int price = rs.getInt("Price");
            String dt = rs.getString("Sale_date");

            res.add("Id " + id + " Name " + name + " Price " + price + " date " + dt);
        }
        return res;
    }

    public List<String> getProductsbySeller(int id) throws SQLException
    {
        List<String> res= new ArrayList<>();
        String query = "SELECT * FROM products WHERE Seller_id = "+id;
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        while (rs.next())
        {
            int Id = rs.getInt("Id");
            String name = rs.getString("Name");
            int price = rs.getInt("Price");
            String dt = rs.getString("Sale_date");

            res.add("Id " + Id + " Name " + name + " Price " + price + " date " + dt);
        }
        return res;
    }

    public List<String> getProductsbyClient(int id) throws SQLException
    {
        List<String> res= new ArrayList<>();
        String query = "SELECT * FROM products WHERE Client_id = "+id;
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        while (rs.next())
        {
            int Id = rs.getInt("Id");
            String name = rs.getString("Name");
            int price = rs.getInt("Price");
            String dt = rs.getString("Sale_date");

            res.add("Id " + Id + " Name " + name + " Price " + price + " date " + dt);
        }
        return res;
    }

    public String Average() throws SQLException
    {
        StringBuilder res = new StringBuilder();
        String query = "SELECT AVG(Price) as Average_price FROM products";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        while (rs.next())
        {
            String avg = rs.getString("Average_price");
            res.append(avg);
        }

        return res.toString();
    }

    public String Popular() throws SQLException
    {
        StringBuilder res = new StringBuilder(" ");
        String query = """
                SELECT products.Id, products.Name, COUNT(*) AS Sales_count
                FROM products
                GROUP BY products.Id, products.Name
                ORDER BY  Sales_count DESC
                LIMIT 1""";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        while (rs.next())
        {
            res.append("Id ").append(rs.getInt("Id")).append(" Name ").append(rs.getString("Name")).append(" Sales count ").append(rs.getString("Sales_count"));
        }

        return res.toString();
    }

    public void deleteRow(int Id) throws SQLException
    {
        String query = """
                 DELETE FROM products
                 WHERE Id = %d
                 """.formatted(Id);

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
    }

    public void updateRow(int Id, String newName, int newPrice, String newDate, int newSid, int newCid ) throws SQLException
    {

        String query = """
                UPDATE products 
                SET 
                Name = ?, 
                Price = ?, 
                Sale_date = ?,
                Client_id = ?,
                Seller_id = ?,
                WHERE Id = ?
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, newName);
        preparedStatement.setInt(2, newPrice);
        preparedStatement.setString(3, newDate);
        preparedStatement.setInt(4, newCid);
        preparedStatement.setInt(5, newSid);
        preparedStatement.setInt(6, Id);
        preparedStatement.executeUpdate();

    }

    public void Close() throws SQLException {
        connection.close();
    }
}
