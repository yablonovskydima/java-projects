<%@ page import="java.util.List, java.util.ArrayList, com.homework.Order" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Main</title>
</head>
<body>
    <%
        for(int i = 0; i < Order.pizza.size(); i++)
        {
            int number = i+1;
            out.println("<h1>Order "+ number +":</h1>");
            out.println("<h3>Pizza: "+Order.pizza.get(i)+"</h3>");
            out.println("<h3>Additional topings: "+Order.additionalToppings.get(i)+"</h3>");
            out.println("<h3>Name: "+Order.clientName.get(i)+"</h3>");
            out.println("<h3>Phone Number: "+Order.phoneNumber.get(i)+"</h3>");
            out.println("<h3>Email: "+Order.email.get(i)+"</h3>");
            out.println("<h3>Address: "+Order.address.get(i)+"</h3><br><br><br>");
        }
    %>
    <h2><a href="order">Make another order</a></h2>
    <h2><a href="checkout">Order</a></h2>
</body>
</html>