package org.example.products;

import org.example.clients.Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.function.Function;

public class ProductsMapper implements Function<ResultSet, Products>
{

    @Override
    public Products apply(ResultSet resultSet) {
        try
        {
            int id = resultSet.getInt("Id");
            String name = resultSet.getString("Name");
            int price = resultSet.getInt("Price");
            String saledate = resultSet.getString("Sale_date");
            int clientid = resultSet.getInt("Client_id");
            int sellerid = resultSet.getInt("Seller_id");
            return new Products(id, name, price, saledate, clientid, sellerid);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
