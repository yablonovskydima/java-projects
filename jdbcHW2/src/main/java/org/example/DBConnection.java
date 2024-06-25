package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection
{
    private final String url;
    private final String user;
    private final String pass;

    public Connection connection;

    public DBConnection(String url, String user, String pass) throws SQLException {
        this.url = url;
        this.user = user;
        this.pass = pass;
        connection = DriverManager.getConnection(url, user, pass);
    }

    public Connection getConnection() {
        return connection;
    }

    public void Close() throws SQLException
    {
        connection.close();
    }
}
