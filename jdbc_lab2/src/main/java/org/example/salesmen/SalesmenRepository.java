package org.example.salesmen;

import org.example.products.Products;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class SalesmenRepository
{

    public Connection connection;

    public SalesmenRepository(Connection connection) throws SQLException
    {
        this.connection = connection;
    }

    public List<Salesmen> getAllSellers(Function<ResultSet, Salesmen> mapper) throws SQLException {
        List<Salesmen> sellers = new ArrayList<>();
        String query = "SELECT * FROM salesmen";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next())
        {
            Salesmen salesman = mapper.apply(rs);
            sellers.add(salesman);
        }

        return sellers;
    }

    public void addSeller(Salesmen salesmen) throws SQLException {
        String query = "INSERT INTO salesmen (Name, PhoneNumber, Email) VALUES(?,  ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, salesmen.getName());
        statement.setString(2, salesmen.getPhonenumber());
        statement.setString(3, salesmen.getEmail());
        statement.executeUpdate();
    }

    public List<String> succesfulSeller() throws SQLException
    {
        List<String> res= new ArrayList<>();
        String query = """
                SELECT salesmen.Id, salesmen.Name, SUM(products.Price) AS Summary
                FROM salesmen
                JOIN products ON salesmen.Id = products.Seller_id
                GROUP BY salesmen.Id, salesmen.Name
                ORDER BY Summary DESC
                LIMIT 1;
                """;


        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        while (rs.next())
        {
            int Id = rs.getInt("Id");
            String name = rs.getString("Name");
            String sum = rs.getString("Summary");

            res.add("Id " + Id + " Name " + name + " summary " + sum);
        }
        return res;
    }

    public void deleteRow(int Id) throws SQLException
    {
        String query = """
                 DELETE FROM salesmen
                 WHERE Id = %d
                 """.formatted(Id);

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
    }

    public void updateRow(int Id, String newName, String newPhone, String newEmail) throws SQLException
    {

        String query = """
                UPDATE salesmen 
                SET 
                Name = ?, 
                PhoneNumber = ?, 
                Email = ?, 
                WHERE Id = ?
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, newName);
        preparedStatement.setString(2, newPhone);
        preparedStatement.setString(3, newEmail);
        preparedStatement.setInt(4, Id);
        preparedStatement.executeUpdate();

    }
    public void Close() throws SQLException {
        connection.close();
    }
}
