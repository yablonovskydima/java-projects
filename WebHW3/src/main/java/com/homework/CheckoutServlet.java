package com.homework;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        if(!Order.pizza.isEmpty())
        {
            Order.pizza.clear();
            Order.additionalToppings.clear();
            Order.clientName.clear();
            Order.email.clear();
            Order.address.clear();
            Order.phoneNumber.clear();
            req.getRequestDispatcher("/ordersuccesful.jsp").forward(req, resp);
        }
        else
        {
            req.getRequestDispatcher("/noorders.jsp").forward(req, resp);
        }
    }
}
