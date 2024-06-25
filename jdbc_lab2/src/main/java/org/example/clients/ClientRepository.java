package org.example.clients;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ClientRepository
{

    public Connection connection;

    public ClientRepository(Connection connection) throws SQLException
    {
        this.connection = connection;
    }

    public List<Client> getAllClients(Function<ResultSet, Client> mapper) throws SQLException {
        List<Client> clients = new ArrayList<>();
        String query = "SELECT * FROM clients";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next())
        {
            Client client = mapper.apply(rs);
            clients.add(client);
        }

        return clients;
    }

    public void addClient(Client client) throws SQLException {
        String query = "INSERT INTO clients (Name, PhoneNumber, Email) VALUES(?,  ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, client.getName());
        statement.setString(2, client.getPhonenumber());
        statement.setString(3, client.getEmail());
        statement.executeUpdate();
    }


    public List<String> succesfulClient() throws SQLException
    {
        List<String> res= new ArrayList<>();
        String query = """
                SELECT clients.Id, clients.Name, SUM(products.Price) AS Summary
                FROM clients
                JOIN products ON clients.Id = products.Client_id
                GROUP BY clients.Id, clients.Name
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
                 DELETE FROM clients
                 WHERE Id = %d
                 """.formatted(Id);

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
    }

    public void updateRow(int Id, String newName, String newPhone, String newEmail) throws SQLException
    {

        String query = """
                UPDATE clients 
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

    public void Close() throws SQLException
    {
        connection.close();
    }
}
